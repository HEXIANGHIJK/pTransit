package com.zd.zhx.pojo;

import com.zd.zhx.pojo.Step;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
public class Walking implements Serializable {

    private String origin;
    private String destination;
    private String distance;
    private String duration;
    //private List<Step> steps;

}
