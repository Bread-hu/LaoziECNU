package com.laozi.entity.book;

public class BookContent {
	private int	id;
	private String	subook_id;
	private String	subook_name;
	private String	subsubook_name;
	private String	content;
	private String	translation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
