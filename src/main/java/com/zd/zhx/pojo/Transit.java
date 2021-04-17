package com.zd.zhx.pojo;

import com.zd.zhx.pojo.Segment;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
public class Transit implements Serializable {
    private String cost;
    private String duration;
    private String nightflag;
    private String walking_distance;
    private String distance;
    private String missed;
    private List<Segment> segments;

}
