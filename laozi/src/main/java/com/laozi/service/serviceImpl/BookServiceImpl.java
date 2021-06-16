package com.laozi.service.serviceImpl;

import com.laozi.dao.BookDao;
import com.laozi.entity.book.Book;
import com.laozi.entity.book.BookContent;
import com.laozi.entity.book.SubBook;
import com.laozi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getBookNamesByCategory(String category, int page) {
		return bookDao.getBookNamesByCategory(category,page*50,(page+1)*50);
	}
	@Override
	public Book getBookByName(String book_name) {
		return bookDao.getBookByName(book_name);
	}

	@Override
	public List<SubBook> getSubBookByBookId(String book_id) {
		return bookDao.getSubBookByBookId(book_id);
	}

	@Override
	public BookContent getBookContent(String subook_id, String subook_name, String subsubook_name) {
		return bookDao.getBookContent(subook_id,subook_name,subsubook_name);
	}


}
