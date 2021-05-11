package com.zd.zhx.service;

import com.zd.zhx.pojo.Walking;
import com.zd.zhx.pojo.Way;
import com.zd.zhx.pojo.FavoriteWay;

import java.util.List;

public interface WayService {

    Double getWalkTime(Double userSpeed, Walking walking);
    Double getWalkTime(Double userSpeed, Way way,int tranCount,int segCount);

    void saveFavoriteWay(String username,String pathStart,String pathEnd,String startPlace,String endPlace);

    boolean checkFavoriteWay(String username,String startPlace,String endPlace);

    List<FavoriteWay> getFavoriteWays(String username);

    void delFavoriteWay(String startPlace,String endPlace);

}
