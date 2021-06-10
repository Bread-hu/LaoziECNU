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
        return "daodejing";
    }

    @GetMapping("/selectChapter")
    @ResponseBody
    public Daodejing getContentByChapter(int chapter){
        this.daodejing= daodejingService.getDaodejing(chapter);
        return this.daodejing;
    }

    @GetMapping("/selectLanguage")
    @ResponseBody
    public String selectLanguage(String language) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.daodejing.getClass().getMethod("get"+language,new Class[]{}).invoke(this.daodejing,new Object[]{});
    }

    @GetMapping("/toOriginal")
    @ResponseBody
    public Map<String,Object> toOriginal(@RequestParam String keywords) throws IOException {
        return daodejingService.searchContentHighlighter(keywords);
    }

    @GetMapping("/daodejingidiom")
    public String toDaodejingIdiom(){
        return "daodejingidiom";
    }

    @GetMapping("/selectIdiom")
    @ResponseBody
    public DaodejingIdiom getIdiomById(String name){
        return daodejingService.getIdiom(name);
    }

}
