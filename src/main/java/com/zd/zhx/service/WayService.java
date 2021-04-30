package com.zd.zhx.service;

import com.zd.zhx.pojo.Walking;
import com.zd.zhx.pojo.Way;
import com.zd.zhx.vo.FavoriteWayVo;

import java.util.List;

public interface WayService {

    Double getWalkTime(Double userSpeed, Walking walking);
    Double getWalkTime(Double userSpeed, Way way,int tranCount,int segCount);

    void saveFavoriteWay(String username,String pathStart,String pathEnd);

    boolean checkFavoriteWay(String username,String pathStart,String pathEnd);

    List<FavoriteWayVo> getFavoriteWays(String username);

}
