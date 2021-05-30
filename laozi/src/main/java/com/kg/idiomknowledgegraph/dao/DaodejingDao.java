package com.kg.idiomknowledgegraph.dao;

import com.kg.idiomknowledgegraph.entity.Daodejing;
import com.kg.idiomknowledgegraph.entity.DaodejingIdiom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DaodejingDao {

    @Select("SELECT * FROM daodejing WHERE chapter=#{chapter}")
    public Daodejing getDaodejingByChapter(int chapter);

    @Select("SELECT * FROM laozi_idiom WHERE id=#{id}")
    public DaodejingIdiom getIdiomById(int id);
}
