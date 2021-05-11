package com.zd.zhx.mapper;

import com.zd.zhx.pojo.FavoriteWay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WayMapper {

    @Insert("insert into favorites(username,start_path_x,start_path_y,end_path_x,end_path_y,start_place,end_place) values(#{username},#{start_path_x},#{start_path_y},#{end_path_x},#{end_path_y},#{start_place},#{end_place}) ")
    public void saveFavoriteWay(FavoriteWay favoriteWay);

    @Select("select * from favorites where username=#{username} and start_place=#{startPlace} and end_place=#{endPlace}")
    public FavoriteWay selectFavoriteWay(@Param("username") String username, @Param("startPlace") String startPlace, @Param("endPlace") String endPlace);

    @Select("select * from favorites")
    public List<FavoriteWay> selectFavoriteWayList();

    @Delete("delete from favorites where start_place=#{startPlace} and end_place=#{endPlace}")
    public void delFavoriteWay(@Param("startPlace") String startPlace,@Param("endPlace") String endPlace);
}
