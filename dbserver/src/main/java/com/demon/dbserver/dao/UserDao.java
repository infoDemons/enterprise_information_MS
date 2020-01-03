package com.demon.dbserver.dao;


import com.demon.dbserver.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);

    @Select("select max(id) from user")
    int getMaxId();

    @Insert("insert into user(id, username, password, role) values (#{id}, #{username}, #{password}, #{role})")
    void addUser(User user);
}
