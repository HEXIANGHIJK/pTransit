package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Data
public class ViaStop implements Serializable {

    private String name;
    private String id;
    private String location;

}
