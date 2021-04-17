package com.zd.zhx.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartureStop implements Serializable {
    private String name;
    private String id;
    private String location;

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }*/
}
