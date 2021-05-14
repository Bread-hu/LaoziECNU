package com.kg.idiomknowledgegraph.controller;

import com.kg.idiomknowledgegraph.service.LaoziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/laozi")
public class LaoziController {

    @Autowired
    private LaoziService laoziService;

    @GetMapping("/daodejing")
    public String toDaodejing(Model model) {
        return "laozi/daodejing";
    }

    @PostMapping("/getDaodejing")
    @ResponseBody
    public String getContentByChapter(int chapter){
        System.out.println("hello");
        System.out.println(chapter);
//        return laoziService.getDaodejing(chapter);
        return "hello";
    }
}
