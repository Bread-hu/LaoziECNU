package com.laozi.dao;

import com.laozi.entity.chengyu.ChengYu;
import com.laozi.entity.chengyu.ChengYuMini;
import com.laozi.entity.chengyu.ChengYuRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChengYuDao {

    @Select("SELECT id,idiom FROM idiom WHERE `firstPhonetic` = #{firstPhonetic}")
    public List<ChengYuMini> getIdioms(String firstPhonetic);

    @Select("SELECT * FROM idiom WHERE `id` = #{id}")
    public ChengYu getIdiomById(int id);

    @Select("SELECT * FROM idiom_relation WHERE `idiom` = #{idiom} limit 1")
    public ChengYuRelation getRelation(String idiom);

    public List<Map<String,String>> getAllIDandNames();

//    @Select("SELECT `content` FROM daodejing WHERE `jingbu` = #{jingbu} AND `category` = \"译文\" ORDER BY `chapter`")
//    public List<String> getTranslations(String jingbu);
//
//    @Select("SELECT `content` FROM daodejing WHERE `jingbu` = #{jingbu} AND `category` = \"注释\" ORDER BY `chapter`")
//    public List<String> getAnnotations(String jingbu);
}
