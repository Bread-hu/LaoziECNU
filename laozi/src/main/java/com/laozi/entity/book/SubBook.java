package com.laozi.entity.book;

public class SubBook {
	private String  book_id;
	private String	subook_id;
	private String	subook_name;
	private String	subsubook_name;
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getSubook_id() {
		return subook_id;
	}

	public void setSubook_id(String subook_id) {
		this.subook_id = subook_id;
	}

	public String getSubook_name() {
		return subook_name;
	}

	public void setSubook_name(String subook_name) {
		this.subook_name = subook_name;
	}

	public String getSubsubook_name() {
		return subsubook_name;
	}

	public void setSubsubook_name(String subsubook_name) {
		this.subsubook_name = subsubook_name;
	}



}
