package com.laozi.dao;

import com.laozi.entity.daodejing.Daodejing;
import com.laozi.entity.daodejing.DaodejingIdiom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DaodejingDao {

    @Select("SELECT * FROM daodejing WHERE chapter=#{chapter}")
    public Daodejing getDaodejingByChapter(int chapter);

    @Select("SELECT * FROM laozi_idiom WHERE name=#{name}")
    public DaodejingIdiom getIdiomById(String name);
}
