package com.laozi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.laozi.entity.chengyu.ChengYu;
import com.laozi.entity.chengyu.ChengYuMini;
import com.laozi.entity.chengyu.ChengYuRelation;
import com.laozi.service.ChengYuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IdiomKGController {

	@Autowired
	ChengYuService chengYuService;

	@RequestMapping(value = "/getIdioms", method = RequestMethod.POST)
	public JSONArray getdata(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String firstPhonetic=in.getString("firstPhonetic");
		JSONArray out = new JSONArray();
		List<ChengYuMini> datas=chengYuService.getIdiomsByFirstPhonetic(firstPhonetic);
		for (int i=0;i<datas.size();i++){
			ChengYuMini chengYu =datas.get(i);
			JSONObject cy = new JSONObject();
			cy.put("id",chengYu.getId());
			cy.put("idiom",chengYu.getIdiom());
			cy.put("name",firstPhonetic);
			out.add(cy);
		}
		return out;
	}

	@RequestMapping(value = "/getIdiomById", method = RequestMethod.POST)
	public JSONObject getIdiomById(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		int id=in.getInteger("id");
		ChengYu data=chengYuService.getIdiomById(id);
		JSONObject out = new JSONObject();
		out.put("id",data.getId());
		out.put("firstPhonetic",data.getFirstPhonetic());
		out.put("idiom",data.getIdiom());
		out.put("idiomPhonetic",data.getIdiomPhonetic());
		out.put("simplePhonetic",data.getSimplePhonetic());
		out.put("explanation",data.getExplanation());
		out.put("allusion",data.getAllusion());
		out.put("example",data.getExample());
		out.put("similar",data.getSimilar());
		out.put("grammar",data.getGrammar());
		out.put("translation",data.getTranslation());
		out.put("antonym",data.getAntonym());
		out.put("structure",data.getStructure());
		out.put("ismodern",data.getIsmodern());
		out.put("frequency",data.getFrequency());
		out.put("feeling",data.getFeeling());
		return out;
	}

	@RequestMapping(value = "/getRelation", method = RequestMethod.POST)
	public JSONObject getRelation(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String name=in.getString("name");
		ChengYuRelation re=chengYuService.getRelation(name);
		JSONObject out = new JSONObject();
		if (re==null){
			out.put("book","");
			out.put("author","");
		}
        else{
			out.put("book",re.getBook());
			out.put("author",re.getAuthor());
		}
		return out;
	}

}
