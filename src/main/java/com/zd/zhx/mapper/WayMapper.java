package com.zd.zhx.mapper;

import com.zd.zhx.vo.FavoriteWayVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WayMapper {

    @Insert("insert into favorites(username,start_path_x,start_path_y,end_path_x,end_path_y) values(#{username},#{spx},#{spy},#{epx},#{epy}) ")
    public void saveFavoriteWay(@Param("username") String username, @Param("spx") String spx, @Param("spy") String spy, @Param("epx") String epx, @Param("epy") String epy);

    @Select("select * from favorites where username=#{username} and start_path_x=#{spx} and start_path_y=#{spy} and end_path_x=#{epx} and end_path_y=#{epy}")
    public FavoriteWayVo selectFavoriteWay(@Param("username") String username, @Param("spx") String spx, @Param("spy") String spy, @Param("epx") String epx, @Param("epy") String epy);

    @Select("select * from favorites")
    public FavoriteWayVo[] selectFavoriteWayList();
}
