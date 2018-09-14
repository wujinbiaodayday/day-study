package com.study.dao;

import com.study.dto.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user(userName,password,age) values (#{userName}, #{password}, #{age})")
    int add(@Param("userName") String userName, @Param("password") String password, @Param("age") Integer age);

    @Update("update user set userName=#{userName},password=#{password},age=#{age} where id=#{id}")
    int update(@Param("userName") String userName, @Param("password") String password, @Param("age") Integer age, @Param("id") Integer id);

    @Delete("delete from user where id = #{id}")
    int delete(@Param("id") Integer id);

    @Select("select * from user")
    List<User> getAllUser();

}
