package com.zd.zhx.vo;

public class FavoriteWayVo {

    private Integer id;
    private String username;
    private String start_path_x;
    private String start_path_y;
    private String end_path_x;
    private String end_path_y;

    public FavoriteWayVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStart_path_x() {
        return start_path_x;
    }

    public void setStart_path_x(String start_path_x) {
        this.start_path_x = start_path_x;
    }

    public String getStart_path_y() {
        return start_path_y;
    }

    public void setStart_path_y(String start_path_y) {
        this.start_path_y = start_path_y;
    }

    public String getEnd_path_x() {
        return end_path_x;
    }

    public void setEnd_path_x(String end_path_x) {
        this.end_path_x = end_path_x;
    }

    public String getEnd_path_y() {
        return end_path_y;
    }

    public void setEnd_path_y(String end_path_y) {
        this.end_path_y = end_path_y;
    }
}