package com.zd.zhx.mapper;

import com.zd.zhx.vo.FavoriteWayVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WayMapper {

    @Insert("insert into favorites(username,start_path_x,start_path_y,end_path_x,end_path_y,start_place,end_place) values(#{username},#{start_path_x},#{start_path_y},#{end_path_x},#{end_path_y},#{start_place},#{end_place}) ")
    public void saveFavoriteWay(FavoriteWayVo favoriteWayVo);

    @Select("select * from favorites where username=#{username} and start_place=#{startPlace} and end_place=#{endPlace}")
    public FavoriteWayVo selectFavoriteWay(@Param("username") String username, @Param("startPlace") String startPlace, @Param("endPlace") String endPlace);

    @Select("select * from favorites")
    public List<FavoriteWayVo> selectFavoriteWayList();
}
