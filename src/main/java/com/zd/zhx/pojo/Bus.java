package com.zd.zhx.pojo;

import com.zd.zhx.pojo.BusLine;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
public class Bus implements Serializable {
    private List<BusLine> busLines;

    /*public List<BusLine> getBusLines() {
        return busLines;
    }

    public void setBusLines(List<BusLine> busLines) {
        this.busLines = busLines;
    }*/
}
