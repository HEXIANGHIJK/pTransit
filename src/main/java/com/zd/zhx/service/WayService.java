package com.zd.zhx.service;

import com.zd.zhx.pojo.Walking;
import com.zd.zhx.pojo.Way;

public interface WayService {

    Double getWalkTime(Double userSpeed, Walking walking);
    Double getWalkTime(Double userSpeed, Way way,int tranCount,int segCount);
}
