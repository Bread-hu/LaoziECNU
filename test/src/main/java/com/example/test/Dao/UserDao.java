package com.example.test.Dao;

import com.example.test.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Insert("insert into user(`userID`,`username`,`password`) values(#{id},#{username},#{password})")
    public int saveUser(User user);

    @Select("select password from user where username=#{username}")
    public String getPwdByName(String username);


}
