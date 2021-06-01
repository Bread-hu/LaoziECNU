package com.laozi.controller;

import com.laozi.entity.daodejing.Daodejing;
import com.laozi.entity.daodejing.DaodejingIdiom;
import com.laozi.service.DaodejingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/daodejing")
public class DaodejingController {

    @Autowired
    private DaodejingService daodejingService;

    private Daodejing daodejing;

    @GetMapping("/daodejing")
    public String toDaodejing() {
        return "/daodejing";
    }

    @PostMapping("/daodejing")
    @ResponseBody
    public Daodejing getContentByChapter(int chapter){
        this.daodejing= daodejingService.getDaodejing(chapter);
        return this.daodejing;
    }

    @PostMapping("/selectLanguage")
    @ResponseBody
    public String selectLanguage(String language) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.daodejing.getClass().getMethod("get"+language,new Class[]{}).invoke(this.daodejing,new Object[]{});
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Map<String,Object>> search(@RequestParam String keywords) throws IOException {
        return daodejingService.searchContentHighlighter(keywords);
    }

    @GetMapping("/daodejingIdiom")
    public String toDaodejingIdiom(){
        return "/daodejingIdiom";
    }

    @GetMapping("/selectIdiom")
    @ResponseBody
    public DaodejingIdiom getIdiomById(int id){
        return daodejingService.getIdiom(id);
    }

}
