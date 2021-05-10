package com.zd.zhx.pojo;

import lombok.Data;

@Data
public class FavoriteWay {

    private Integer id;
    private String username;
    private String start_path_x;
    private String start_path_y;
    private String end_path_x;
    private String end_path_y;
    private String start_place;
    private String end_place;

    public FavoriteWay() {
    }

    public FavoriteWay(String username, String start_path_x, String start_path_y, String end_path_x, String end_path_y, String start_place, String end_place) {
        this.username = username;
        this.start_path_x = start_path_x;
        this.start_path_y = start_path_y;
        this.end_path_x = end_path_x;
        this.end_path_y = end_path_y;
        this.start_place = start_place;
        this.end_place = end_place;
    }

}
