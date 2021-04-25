package com.zd.zhx.service.impl;

import com.zd.zhx.pojo.*;
import com.zd.zhx.service.WayService;

import java.text.DecimalFormat;
import java.util.List;

public class WayServiceImpl implements WayService {
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

}
