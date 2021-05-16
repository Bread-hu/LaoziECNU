package com.kg.idiomknowledgegraph.controller;

import com.kg.idiomknowledgegraph.bean.Daodejing;
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
    public Daodejing getContentByChapter(int chapter){
        return laoziService.getDaodejing(chapter);
    }

}
