package com.laozi.dao;

import com.laozi.entity.author.Author;
import com.laozi.entity.author.AuthorData;
import com.laozi.entity.book.DynastyCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorDao {

    @Select("Select * FROM author")
    public List<Author> getAuthorListAll();

    @Select("Select count(*) FROM author")
    public int getAuthorCount();

    @Select("Select count(*) FROM author WHERE `author_dynasty` = #{dynasty}")
    public int getAuthorCountByDynasty(String dynasty);

    @Select("Select * FROM author WHERE `author_dynasty` = #{dynasty}")
    public List<Author> getAuthorByDynasty(String dynasty);

    @Select("Select * FROM author limit #{pageNo}, #{pageSize}")
    public List<Author> getAuthorSliceByPage(Map map);

    @Select("Select * FROM author WHERE `author_dynasty` = #{dynasty} limit #{pageNo}, #{pageSize}")
    public List<Author> getAuthorSliceByPageAndDynasty(Map map);

    @Select("select author_dynasty, count(*) as author_count from author group by author_dynasty")
    public List<DynastyCount> getCountByDynasty();

    @Select("select sub_title as title, sub_content as content from author_detail where person_name = #{name}")
    public List<AuthorData> getTitleAndContent(String name);

}
