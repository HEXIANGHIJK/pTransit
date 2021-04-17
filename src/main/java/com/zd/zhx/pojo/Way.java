package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Data
public class Way implements Serializable {

    private String status;

    private String info;

    private String infocode;

    private String count;

    private Route route;

    @Override
    public String toString() {
        return "Way{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", infocode='" + infocode + '\'' +
                ", count='" + count + '\'' +
                ", route=" + route +
                '}';
    }
}