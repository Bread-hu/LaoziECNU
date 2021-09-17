package com.laozi.controller;

import com.alibaba.fastjson.JSON;
import com.laozi.entity.daodejing.Daodejing;
import com.laozi.service.BookService;
import com.laozi.service.ChengYuService;
import com.laozi.service.DaodejingService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestController {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;
    @Autowired
    DaodejingService daodejingService;
    @Autowired
    ChengYuService chengYuService;
    @Autowired
    BookService bookService;

//    @Autowired
//    TestService testService;



    //把成语和它url放es中
    @Test
    public void insertAllIdioms() throws IOException {
        BulkRequest bulkRequest=new BulkRequest();
        for(int i=1;i<=81;i++){
            Daodejing daodejing= daodejingService.getDaodejing(i);

            bulkRequest.add(new IndexRequest("daodejing").id(Integer.toString(i)).source(JSON.toJSONString(daodejing), XContentType.JSON));
        }
        BulkResponse bulkResponse=client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(!bulkResponse.hasFailures());
    }


    // 把mysql的道德经插入到es中
    @Test
    public void insertAllPara() throws IOException {
        BulkRequest bulkRequest=new BulkRequest();
        for(int i=1;i<=81;i++){
            Daodejing daodejing= daodejingService.getDaodejing(i);

            bulkRequest.add(new IndexRequest("daodejing").id(Integer.toString(i)).source(JSON.toJSONString(daodejing), XContentType.JSON));
        }
        BulkResponse bulkResponse=client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(!bulkResponse.hasFailures());
    }

    // 把mysql的道德经成语插入到es中
//    @Test
//    public void insertAllIdiom() throws IOException {
//        BulkRequest bulkRequest=new BulkRequest();
//        for(int i=0;i<=51;i++){
//            DaodejingIdiom daodejingIdiom= daodejingService.getIdiom(i);
//            bulkRequest.add(new IndexRequest("daodejing_idiom").id(Integer.toString(i)).source(JSON.toJSONString(daodejingIdiom), XContentType.JSON));
//        }
//        BulkResponse bulkResponse=client.bulk(bulkRequest, RequestOptions.DEFAULT);
//        System.out.println(!bulkResponse.hasFailures());
//    }


    @Test
    public void getByChapter() throws IOException {
        GetRequest getRequest=new GetRequest("test","1");
        GetResponse getResponse=client.get(getRequest,RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());;
        System.out.println(getResponse);
    }

    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest=new SearchRequest("test");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery("道可道","original","annotation","translation").field("original",3));
        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder.field("original");
        sourceBuilder.highlighter(highlightBuilder);       searchRequest.source(sourceBuilder);
        SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);
        for(SearchHit hit:response.getHits()){
            Map<String, HighlightField> highlightFieldMap=hit.getHighlightFields();
            HighlightField highlightField=highlightFieldMap.get("original");
            if(highlightField!=null){
                Text[] fragments=highlightField.fragments();
                String fragment=fragments[0].string();
                System.out.println(fragment);
            }

        }

    }

    @Test
    public void testSearch2() throws IOException {
        SearchRequest searchRequest=new SearchRequest("test");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery("道可道","original","annotation","translation").field("original",3));
        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder.field("original");
        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse response=client.search(searchRequest, RequestOptions.DEFAULT);

        List<Map<String,Object>> list=new ArrayList<>();
        for(SearchHit searchHit:response.getHits()){
            Map<String, HighlightField> highlightFieldMap=searchHit.getHighlightFields();
            HighlightField highlightField=highlightFieldMap.get("original");
            Map<String,Object> source=searchHit.getSourceAsMap();
            if(highlightField!=null){
                Text[] fragments=highlightField.fragments();
                String temp="";
                for(Text text:fragments){
                    temp+=text;
                }
                source.put("original",temp);
            }
            list.add(source);
        }
        System.out.println(list.get(0).toString());
    }
}
