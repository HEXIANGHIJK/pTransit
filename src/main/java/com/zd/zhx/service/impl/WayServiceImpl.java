package com.zd.zhx.service.impl;

import com.zd.zhx.mapper.WayMapper;
import com.zd.zhx.pojo.*;
import com.zd.zhx.service.WayService;
import com.zd.zhx.pojo.FavoriteWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class WayServiceImpl implements WayService {

    @Autowired
    private WayMapper wayMapper;

    @Override
    public Double getWalkTime(Double userSpeed, Walking walking) {
        String destinationStr = walking.getDestination();
        double destination = 0;
        if (destinationStr!=null){
             destination=Double.parseDouble(destinationStr);
             Double time=destination/userSpeed;
             DecimalFormat df = new DecimalFormat("#.00");

            return Double.valueOf(df.format(time));
        }
        else
            return null;
    }

    @Override
    public Double getWalkTime(Double userSpeed, Way way, int tranCount, int segCount) {
        Route route = way.getRoute();
        Transit transits = route.getTransits().get(tranCount);
        Segment segment = transits.getSegments().get(segCount);
        Walking walking = segment.getWalking();

        String destinationStr = walking.getDestination();
        double destination = 0;
        if (destinationStr!=null){
            destination=Double.parseDouble(destinationStr);
            Double time=destination/userSpeed;
            DecimalFormat df = new DecimalFormat("#.00");

            return Double.valueOf(df.format(time));
        }
        else
            return null;
    }

    @Override
    public void saveFavoriteWay(String username, String pathStart, String pathEnd, String startPlace, String endPlace) {
        String[] pathStartStrs = pathStart.split(",");
        String[] pathEndStrs = pathEnd.split(",");
        //System.out.println(username+","+pathStartStrs[0]+","+pathStartStrs[1]+","+pathEndStrs[0]+","+pathEndStrs[1]);
        wayMapper.saveFavoriteWay(new FavoriteWay(username,pathStartStrs[0],pathStartStrs[1],pathEndStrs[0],pathEndStrs[1],startPlace,endPlace));
    }

    @Override
    public boolean checkFavoriteWay(String username, String startPlace, String endPlace) {

        FavoriteWay favoriteWay = wayMapper.selectFavoriteWay(username, startPlace, endPlace);
        return favoriteWay != null;
    }

    @Override
    public List<FavoriteWay> getFavoriteWays(String username) {

        return wayMapper.selectFavoriteWayList();
    }

    @Override
    public void delFavoriteWay(String startPlace, String endPlace) {
        wayMapper.delFavoriteWay(startPlace, endPlace);
    }

}
