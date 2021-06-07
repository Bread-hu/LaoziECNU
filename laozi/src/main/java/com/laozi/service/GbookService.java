package com.laozi.service;

import com.laozi.entity.book.Gbook;

import java.util.List;

public interface GbookService {
    public List<Gbook> getRootBooks();

    public List<Gbook> getBooks(String parName);

    public List<Gbook> getBookInfo(String bookname);
}
