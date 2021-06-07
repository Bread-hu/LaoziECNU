package com.laozi.controller;

import com.alibaba.fastjson.JSONObject;
import com.laozi.entity.book.Gbook;
import com.laozi.service.GbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralArticleController {

    public static String readTxt(File file) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader br = new BufferedReader(in);
        StringBuffer content = new StringBuffer();
        while ((s=br.readLine())!=null){
            content = content.append(s);
        }
        return content.toString();
    }

    @Autowired
    private GbookService gbookService;

    @GetMapping("/gbooks")
    public String getGbooksPage(String book, Model model) throws IOException {
        System.out.println("Gbooks page!");

        String curBookName = book;
        Gbook curBook = new Gbook();

        List<Gbook> gbooks = new ArrayList<Gbook>();

        if(curBookName.equals("首页")) {
            gbooks = gbookService.getRootBooks();
            curBook.setBook_path("首页");
            curBook.setIs_dir("1");
        }
        else {
            gbooks = gbookService.getBooks(curBookName);
            curBook = gbookService.getBookInfo(curBookName).get(0);
        }

        System.out.println(curBook.getBook_path());
        String[] pathList = curBook.getBook_path().split("\\\\");

        model.addAttribute("curPath", pathList);
        model.addAttribute("curBook", curBook);
        model.addAttribute("books", gbooks);
        model.addAttribute("curName", curBookName);

        if(curBook.getIs_dir().equals("0")) {
            String test = readTxt(new File("D:\\Myfiles\\laozi\\" + curBook.getBook_path() + "\\原文.txt"));
            model.addAttribute("content", test);
        }
        System.out.println("D:\\Myfiles\\laozi\\" + curBook.getBook_path() + "\\原文.txt");

        return "generalArticle";
    }


    @PostMapping("/gbooks")
    @ResponseBody
    public JSONObject gbooksPage(String book) throws IOException {
        System.out.println("Gbooks page!");

        String curBookName = book;
        Gbook curBook = new Gbook();

        List<Gbook> gbooks = new ArrayList<Gbook>();

        if(curBookName.equals("首页")) {
            gbooks = gbookService.getRootBooks();
            curBook.setBook_path("首页");
            curBook.setIs_dir("1");
        }
        else {
            gbooks = gbookService.getBooks(curBookName);
            curBook = gbookService.getBookInfo(curBookName).get(0);
        }

        System.out.println(curBook.getBook_path());
        String[] pathList = curBook.getBook_path().split("\\\\");

        JSONObject res = new JSONObject();
        res.put("curPath", pathList);
        res.put("curBook", curBook);
        res.put("books", gbooks);
        res.put("curName", curBookName);

        if(curBook.getIs_dir().equals("0")) {
            String test = readTxt(new File("D:\\Myfiles\\laozi\\" + curBook.getBook_path() + "\\原文.txt"));
            res.put("content", test);
        }
        System.out.println("D:\\Myfiles\\laozi\\" + curBook.getBook_path() + "\\原文.txt");

        return res;
    }

//    @GetMapping("/gbooks")
//    public String getGbooksPage(String bookName, Model model){
//        System.out.println("Gbooks page!");
//
//        List<Gbook> gbooks = gbookService.getBooks(bookName);
//        System.out.println(gbooks.get(0).getBook_name());
//
//        model.addAttribute("books", gbooks);
//        return "generalArticle";
//    }
}
