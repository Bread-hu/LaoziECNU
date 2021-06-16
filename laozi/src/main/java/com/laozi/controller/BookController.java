package com.laozi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.laozi.entity.book.Book;
import com.laozi.entity.book.BookContent;
import com.laozi.entity.book.SubBook;
import com.laozi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/literaturesByType", method = RequestMethod.POST)
	public JSONArray getliteraturesByType(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String category=in.getString("category");
		int page=in.getInteger("page");
		List<Book> names= bookService.getBookNamesByCategory(category,page);
		JSONArray out = new JSONArray();
		for (int i=0;i<names.size();i++){
			Book book=names.get(i);
			JSONObject re=new JSONObject();
			re.put("book_name",book.getBook_name());
			re.put("introduction", book.getIntroduction());
			re.put("category", category);
			out.add(re);
		}
		return out;
	}

	@RequestMapping(value = "/getBookByName", method = RequestMethod.POST)
	public JSONObject getBookByName(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String book_name=in.getString("book_name");
		Book book= bookService.getBookByName(book_name);
		JSONObject out=new JSONObject();
		out.put("book_name",book_name);
		out.put("book_id",book.getBook_id());
		out.put("dynasty",book.getDynasty());
		out.put("introduction",book.getIntroduction());
		return out;
	}


	@RequestMapping(value = "/getSubBookByBookId", method = RequestMethod.POST)
	public JSONArray getSubBookByBookId(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String book_id=in.getString("book_id");
		List<SubBook> subBooks= bookService.getSubBookByBookId(book_id);
		JSONArray out = new JSONArray();
		for (int i=0;i<subBooks.size();i++){
			SubBook subBook=subBooks.get(i);
			JSONObject re=new JSONObject();
			re.put("book_id",subBook.getBook_id());
			re.put("subook_id",subBook.getSubook_id());
			re.put("subook_name",subBook.getSubook_name());
			re.put("subsubook_name",subBook.getSubsubook_name());
			out.add(re);
		}
		return out;
	}

	@RequestMapping(value = "/getBookContent", method = RequestMethod.POST)
	public JSONObject getBookContent(@RequestBody String param) {
		JSONObject in = JSONObject.parseObject(param);
		String subook_id=in.getString("subook_id");
		String subook_name=in.getString("subook_name");
		String subsubook_name=in.getString("subsubook_name");
		System.out.println(in);

		BookContent bookContent= bookService.getBookContent(subook_id,subook_name,subsubook_name);
		JSONObject out=new JSONObject();
		out.put("subook_id",bookContent.getSubook_id());
		out.put("subook_name",bookContent.getSubook_name());
		out.put("subsubook_name",bookContent.getSubsubook_name());
		out.put("content",bookContent.getContent());
		out.put("translation",bookContent.getTranslation());
		return out;
	}

}
