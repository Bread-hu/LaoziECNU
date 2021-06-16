package com.laozi.dao;

import com.laozi.entity.book.Book;
import com.laozi.entity.book.BookContent;
import com.laozi.entity.book.SubBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

     @Select("SELECT * FROM core_books_data WHERE `category` = #{category}  limit  #{start} , #{end}")
     List<Book> getBookNamesByCategory(String category,int start,int end);

     @Select("SELECT * FROM core_books_data WHERE `book_name` = #{book_name} limit 1")
     Book getBookByName(String book_name);

     @Select("SELECT r.book_id,r.subook_id,d.subook_name,d.subsubook_name FROM core_books_relation as r,core_content_data as d where r.subook_id = d.subook_id and r.book_id = #{book_id}")
     List<SubBook> getSubBookByBookId(String book_id);

     @Select("SELECT * FROM core_content_data WHERE `subook_id` = #{subook_id}  and `subook_name` = #{subook_name} and `subsubook_name` = #{subsubook_name} ")
     BookContent getBookContent(String subook_id, String subook_name, String subsubook_name);

//    @Select("SELECT id,idiom FROM idiom WHERE `firstPhonetic` = #{firstPhonetic}")
//     List<ChengYuMini> getLimitNumBooksByType(String firstPhonetic);



//    @Select("SELECT `content` FROM daodejing WHERE `jingbu` = #{jingbu} AND `category` = \"译文\" ORDER BY `chapter`")
//    public List<String> getTranslations(String jingbu);
//
//    @Select("SELECT `content` FROM daodejing WHERE `jingbu` = #{jingbu} AND `category` = \"注释\" ORDER BY `chapter`")
//    public List<String> getAnnotations(String jingbu);
}
