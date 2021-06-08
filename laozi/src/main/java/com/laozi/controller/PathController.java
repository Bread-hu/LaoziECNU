package com.laozi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	@RequestMapping(value = "/index")
	public String index() {return "index";}
    //------------------------------------------------------成语
	@RequestMapping(value = "/chengyu")
	public String chengyu() { return "chengyu"; }
	@RequestMapping(value = "/chengyu_show")
	public String chengyu_show(Model model) {return "chengyu_show";}
	@RequestMapping(value = "/chengyu_show_detail")
	public String chengyu_show_detail(Model model) {
		return "chengyu_show_detail";
	}

	//------------------------------------------------------作者
	@RequestMapping(value = "/author")
	public String author() {
		return "author";
	}
	//------------------------------------------------------文献

	@RequestMapping(value = "/literature")
	public String literature() {
		return "literature";
	}
	@RequestMapping(value = "/book")
	public String book() {
		return "book";
	}
	@RequestMapping(value = "/book_detail")
	public String book_detail() {
		return "book_detail";
	}
	//------------------------------------------------------时空gis

}
