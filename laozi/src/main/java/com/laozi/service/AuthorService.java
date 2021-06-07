package com.laozi.service;

import com.laozi.entity.author.Author;
import com.laozi.entity.author.AuthorData;
import com.laozi.entity.book.DynastyCount;

import java.util.List;
import java.util.Map;

public interface AuthorService {
    public Map<String, String> getAll();

    public int getAllAuthorNum();

    public int getAuthorSumByDynasty(String dynasty);

    public List<Author> getAuthorList();

    public List<Author> getAuthorSlice(Map map);

    public List<Author> getAuthorSliceWithDynasty(Map map);

    public List<DynastyCount> getDynastyCount();

    public List<AuthorData> getAuthorDetailData(String name);
}
