package com.zd.zhx.mapper;

import com.zd.zhx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user values(#{username},#{password},#{type},#{img},#{speed})")
    void insertUser(User user);

    @Select("select speed from user where username={username}")
    Double getUserSpeed(String username);
}
