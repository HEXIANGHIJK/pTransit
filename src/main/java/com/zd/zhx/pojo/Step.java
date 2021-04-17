package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
public class Step implements Serializable {
    private String instruction;
    /*private List road;*/
    private String distance;
    /*private List duration;*/
    private String polyline;
    private String action;
    /*private List assistant_action;*/

}
