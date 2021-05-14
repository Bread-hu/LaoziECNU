package com.example.test.controller;

import com.example.test.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("index")
    public String toIndex(Model model) {
        User user=new User();
        model.addAttribute("xiaoming",user);
        return "dytt/login";
    }

    @GetMapping("register")
    public String toRegister() {
        return "dytt/register";
    }
}
