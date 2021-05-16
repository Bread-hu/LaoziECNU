package com.kg.idiomknowledgegraph.dao;

import com.kg.idiomknowledgegraph.bean.Daodejing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DaodejingDao {

    @Select("SELECT * FROM daodejing WHERE chapter=#{chapter}")
    public Daodejing getByChapter(int chapter);

}
