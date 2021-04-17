package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
public class Route implements Serializable {
    private String origin;

    private String destination;

    private String distance;

    private String taxi_cost;

    private List<Transit> transits;

}
