package com.kg.idiomknowledgegraph.service.serviceImpl;

import com.kg.idiomknowledgegraph.entity.DaodejingIdiom;
import com.kg.idiomknowledgegraph.service.LaoziService;
import com.kg.idiomknowledgegraph.entity.Daodejing;
import com.kg.idiomknowledgegraph.dao.DaodejingDao;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LaoziServiceImpl implements LaoziService {


    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Autowired
    private DaodejingDao daodejingDao;

    @Override
    public DaodejingIdiom getIdiom(int id) {
        return daodejingDao.getIdiomById(id);
    }

    @Override
    public Daodejing getDaodejing(int chapter) {
        return daodejingDao.getDaodejingByChapter(chapter);
    }

    @Override
    public List<Map<String, Object>> searchContentHighlighter(String keywords) throws IOException {
        SearchRequest searchRequest=new SearchRequest("daodejing");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery(keywords,"original","annotation","translation").field("original",3));
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
        return list;
    }

}
