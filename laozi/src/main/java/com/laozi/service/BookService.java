package com.laozi.service;

import com.laozi.entity.book.Book;
import com.laozi.entity.book.BookContent;
import com.laozi.entity.book.SubBook;

import java.util.List;

public interface BookService {
	List<Book> getBookNamesByCategory(String category,int page);
	Book getBookByName(String book_name);
	List<SubBook> getSubBookByBookId(String book_id);
	BookContent   getBookContent(String subook_id, String subook_name, String subsubook_name);
}
