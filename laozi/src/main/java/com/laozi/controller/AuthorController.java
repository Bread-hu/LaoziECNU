package com.laozi.controller;

import com.alibaba.fastjson.JSONObject;
import com.laozi.entity.book.DynastyCount;
import com.laozi.entity.author.Author;
import com.laozi.entity.author.AuthorData;
import com.laozi.service.AuthorService;
import com.laozi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public String authorPage(Model model){
        System.out.println("author page");
        model.addAttribute("authors", authorService.getAuthorList());
        return "author";
    }

    @GetMapping("/page")
    public String getAuthorPageByDynasty(@RequestParam Map<String,Object> Pmap, Model model){
        System.out.printf("dynasty: %s, pageNum: %s %n", Pmap.get("dynasty"), Pmap.get("pageNumber"));
        String dynasty = (String) Pmap.get("dynasty");

        List<String> dynasty_list = Arrays.asList("不限", "先秦", "两汉", "晋魏", "南北朝", "隋唐", "唐代", "五代", "宋代", "金朝", "元代", "明代", "清代");
        String pagenum = (String) Pmap.get("pageNumber");
        String curr_dynasty = dynasty;
        if(curr_dynasty == null)
            curr_dynasty = "不限";

        int pageSize = 20;
        int pageNo = 0;
        if(pagenum == null)
            pageNo = 1;
        else {
            pageNo = Integer.valueOf(pagenum);
            if(pageNo < 1)
                pageNo = 1;
        }

        int totalCount = 0;

        int count;
        if(curr_dynasty.equals("不限")) {
            count = authorService.getAllAuthorNum();
            System.out.println("curr dynasty 不限");
        }
        else{
            System.out.printf("curr dynasty: %s %n", curr_dynasty);
            count = authorService.getAuthorSumByDynasty(curr_dynasty);
        }

        if(count > 0){
            totalCount=count;
        }
        int maxPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        if(maxPage == 0) {
            model.addAttribute("authors", null);
            model.addAttribute("currPage", pageNo);
            model.addAttribute("maxPage", maxPage);
            model.addAttribute("dynasty_list", dynasty_list);
            model.addAttribute("curr_dynasty", curr_dynasty);
            return "author";
        }

        if(pageNo>maxPage){
            pageNo = maxPage;
        }
        int tmpPageNo = (pageNo-1)*pageSize;
        Map map=new HashMap();
        map.put("pageNo", tmpPageNo);
        map.put("pageSize", pageSize);


        List<Author> authorListSlice;
        if(curr_dynasty.equals("不限"))
            authorListSlice = authorService.getAuthorSlice(map);
        else{
            map.put("dynasty", curr_dynasty);
            authorListSlice = authorService.getAuthorSliceWithDynasty(map);
        }

        // compute the nav range
        List<Integer> rangeNum = new ArrayList<Integer>();
        if(pageNo>5 && pageNo<maxPage-5){
            for(int i=pageNo-5; i<pageNo+5; i++)
                rangeNum.add(i);
        }
        else if(pageNo<=5){
            for(int i=1;i<=10;i++)
                if(i<=maxPage)
                    rangeNum.add(i);
        }
        else if(pageNo>=maxPage-5){
            for(int i=maxPage-9;i<=maxPage;i++)
                if(i>=1)
                    rangeNum.add(i);
        }
        model.addAttribute("authors", authorListSlice);
        model.addAttribute("currPage", pageNo);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("rangeList", rangeNum);
        model.addAttribute("dynasty_list", dynasty_list);
        model.addAttribute("curr_dynasty", curr_dynasty);

        return "author";
    }

    @GetMapping("/authorDetail")
    public String authorDetail(String name){
        return "authorDetail";
    }

    @PostMapping("/page")
    @ResponseBody
    public JSONObject AuthorPageByDynasty(@RequestParam Map<String,Object> Pmap){
        System.out.printf("dynasty: %s, pageNum: %s %n", Pmap.get("dynasty"), Pmap.get("pageNumber"));
        String dynasty = (String) Pmap.get("dynasty");

        List<String> dynasty_list = Arrays.asList("不限", "先秦", "两汉", "晋魏", "南北朝", "隋唐", "唐代", "五代", "宋代", "金朝", "元代", "明代", "清代");
        String pagenum = (String) Pmap.get("pageNumber");
        String curr_dynasty = dynasty;
        if(curr_dynasty == null)
            curr_dynasty = "不限";

        int pageSize = 20;
        int pageNo = 0;
        if(pagenum == null)
            pageNo = 1;
        else {
            pageNo = Integer.valueOf(pagenum);
            if(pageNo < 1)
                pageNo = 1;
        }

        int totalCount = 0;

        int count;
        if(curr_dynasty.equals("不限")) {
            count = authorService.getAllAuthorNum();
            System.out.println("curr dynasty 不限");
        }
        else{
            System.out.printf("curr dynasty: %s %n", curr_dynasty);
            count = authorService.getAuthorSumByDynasty(curr_dynasty);
        }

        if(count > 0){
            totalCount=count;
        }
        int maxPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        // create return value
        JSONObject res = new JSONObject();

        if(maxPage == 0) {
            res.put("authors", null);
            res.put("currPage", pageNo);
            res.put("maxPage", maxPage);
            res.put("dynasty_list", dynasty_list);
            res.put("curr_dynasty", curr_dynasty);

            return res;
        }

        if(pageNo>maxPage){
            pageNo = maxPage;
        }
        int tmpPageNo = (pageNo-1)*pageSize;
        Map map=new HashMap();
        map.put("pageNo", tmpPageNo);
        map.put("pageSize", pageSize);


        List<Author> authorListSlice;
        if(curr_dynasty.equals("不限"))
            authorListSlice = authorService.getAuthorSlice(map);
        else{
            map.put("dynasty", curr_dynasty);
            authorListSlice = authorService.getAuthorSliceWithDynasty(map);
        }

        // compute the nav range
        List<Integer> rangeNum = new ArrayList<Integer>();
        if(pageNo>5 && pageNo<maxPage-5){
            for(int i=pageNo-5; i<pageNo+5; i++)
                rangeNum.add(i);
        }
        else if(pageNo<=5){
            for(int i=1;i<=10;i++)
                if(i<=maxPage)
                    rangeNum.add(i);
        }
        else if(pageNo>=maxPage-5){
            for(int i=maxPage-9;i<=maxPage;i++)
                if(i>=1)
                    rangeNum.add(i);
        }

        //return result
        res.put("authors", authorListSlice);
        res.put("currPage", pageNo);
        res.put("maxPage", maxPage);
        res.put("dynasty_list", dynasty_list);
        res.put("curr_dynasty", curr_dynasty);

        return res;
    }

    @PostMapping("/authorDetail")
    @ResponseBody
    public JSONObject AuthorDetail(@RequestParam Map<String,Object> Pmap){
        String author_name = (String) Pmap.get("author_name");
        System.out.println("author_name: "+ author_name);
        List<AuthorData> authorDataList = authorService.getAuthorDetailData(author_name);
        HashMap<String, String> h = new HashMap<String, String>();
        for(AuthorData data: authorDataList){
            h.put(data.getTitle(), data.getContent());
        }
        JSONObject res = new JSONObject();
        res.put("data", h);
        res.put("name", author_name);
        return res;
    }

    @GetMapping("/pp")
    public String authorPage(String pageNumber,  Model model){
        String dynasty = "";

        List<String> dynasty_list = Arrays.asList("不限", "先秦", "两汉", "晋魏", "南北朝", "隋唐", "唐代", "五代", "宋代", "金朝", "元代", "明代", "清代");
        String pagenum = pageNumber;
        String curr_dynasty = dynasty;
        if(curr_dynasty == "")
            curr_dynasty = "不限";

        int pageSize = 20;
        int pageNo = 0;
        if(pagenum == null)
            pageNo = 1;
        else {
            pageNo = Integer.valueOf(pagenum);
            if(pageNo < 1)
                pageNo = 1;
        }

        int totalCount = 0;

        int count;
        if(curr_dynasty == "不限")
            count = authorService.getAllAuthorNum();
        else{
            count = authorService.getAuthorSumByDynasty(curr_dynasty);
        }

        if(count > 0){
            totalCount=count;
        }
        int maxPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo = maxPage;
        }
        int tmpPageNo = (pageNo-1)*pageSize;
        Map map=new HashMap();
        map.put("pageNo", tmpPageNo);
        map.put("pageSize", pageSize);


        List<Author> authorListSlice;
        if(curr_dynasty == "不限")
            authorListSlice = authorService.getAuthorSlice(map);
        else{
            map.put("dynasty", curr_dynasty);
            authorListSlice = authorService.getAuthorSliceWithDynasty(map);
        }

        // compute the nav range
        List<Integer> rangeNum = new ArrayList<Integer>();
        if(pageNo>5 && pageNo<maxPage-5){
            for(int i=pageNo-5; i<pageNo+5; i++)
                rangeNum.add(i);
        }
        else if(pageNo<=5){
            for(int i=1;i<=10;i++)
                if(i<=maxPage)
                    rangeNum.add(i);
        }
        else if(pageNo>=maxPage-5){
            for(int i=maxPage-9;i<=maxPage;i++)
                if(i>=1)
                    rangeNum.add(i);
        }
        model.addAttribute("authors", authorListSlice);
        model.addAttribute("currPage", pageNo);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("rangeList", rangeNum);
        model.addAttribute("dynasty_list", dynasty_list);
        model.addAttribute("curr_dynasty", curr_dynasty);
        return "author";
    }

    @PostMapping("/dynastycount")
    @ResponseBody
    public JsonResult getdynastycount(@RequestParam Map<String,Object> Pmap){
        String page = (String)Pmap.get("pageNum");
        String dynasty = (String)Pmap.get("dynasty");
        System.out.println(page);
        System.out.println(dynasty);
        List<DynastyCount> b = authorService.getDynastyCount();
        JsonResult jr = new JsonResult();
        jr.setData(b);
        return jr;
    }

    @PostMapping("/test")
    @ResponseBody
    public JSONObject gettest(@RequestParam Map<String,Object> Pmap){
        String page = (String)Pmap.get("pageNum");
        String dynasty = (String)Pmap.get("dynasty");
        System.out.println(page);
        System.out.println(dynasty);
        List<DynastyCount> b = authorService.getDynastyCount();
        for(DynastyCount a : b) {
            System.out.println(a.getDynasty());
            System.out.println(a.getCount());
        }
        JSONObject j = new JSONObject();
        j.put("res", b);
        return j;
    }

}
