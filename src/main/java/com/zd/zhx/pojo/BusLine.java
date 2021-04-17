package com.zd.zhx.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Data
public class BusLine implements Serializable {

    private DepartureStop departure_stop;
    private ArrivalStop arrival_stop;
    private String name;
    private String id;
    private String type;
    private String distance;
    private String duration;
    private String polyline;
    private String bustimetag;
    /*private List start_time;
    private List end_time;*/
    private Integer via_num;
    private List<ViaStop> via_stops;

    /*public DepartureStop getDeparture_stop() {
        return departure_stop;
    }

    public void setDeparture_stop(DepartureStop departure_stop) {
        this.departure_stop = departure_stop;
    }

    public ArrivalStop getArrival_stop() {
        return arrival_stop;
    }

    public void setArrival_stop(ArrivalStop arrival_stop) {
        this.arrival_stop = arrival_stop;
    }

    public String getName() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getBustimetag() {
        return bustimetag;
    }

    public void setBustimetag(String bustimetag) {
        this.bustimetag = bustimetag;
    }

    *//*public List getStart_time() {
        return start_time;
    }

    public void setStart_time(List start_time) {
        this.start_time = start_time;
    }

    public List getEnd_time() {
        return end_time;
    }

    public void setEnd_time(List end_time) {
        this.end_time = end_time;
    }*//*

    public Integer getVia_num() {
        return via_num;
    }

    public void setVia_num(Integer via_num) {
        this.via_num = via_num;
    }

    public List<ViaStop> getVia_stops() {
        return via_stops;
    }

    public void setVia_stops(List<ViaStop> via_stops) {
        this.via_stops = via_stops;
    }*/
}
