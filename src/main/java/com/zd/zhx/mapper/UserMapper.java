package com.zd.zhx.mapper;

import com.zd.zhx.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username,password,type,img,speed) values(#{username},#{password},#{type},#{img},#{speed})")
    void insertUser(User user);

    @Select("select speed from user where username=#{username}")
    Double getUserSpeed(String username);

    @Update({"<script> " +
            "update user set password=#{password}" +
            "<if test='type!=null'> , type=#{type} </if> " +
            "<if test='img!=null'> , img=#{img} </if> " +
            "<if test='speed!=null'> , speed=#{speed} </if> " +
            "where username=#{username}" +
            "</script>"})
    void userUpdate(@Param("username") String username,@Param("password") String password,@Param("type") String type,@Param("img") String img,@Param("speed") String speed);//

    @Delete("delete from user where username = #{username}")
    void userDel(String username);
}
