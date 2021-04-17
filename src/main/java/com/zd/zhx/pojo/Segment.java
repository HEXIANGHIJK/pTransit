package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Segment implements Serializable {
    /*private List taxi;*/
    private Walking walking;
    private Bus bus;
    private Entrance entrance;
    /*private List exit;*/
    private RailWay railWay;


}
