package com.zd.zhx.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.zd.zhx.pojo.Transit;
import com.zd.zhx.pojo.Walking;
import com.zd.zhx.pojo.Way;
import com.zd.zhx.service.ApiService;
import com.zd.zhx.utils.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/way")
public class WayController {

    @Autowired
    private ApiService apiService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @ResponseBody
    @RequestMapping("/getWay")
    public ResponseEntity<Way> getWay(HttpServletRequest request,String origin,String destination) throws JSONException, JsonProcessingException {
        //得到long类型当前时间
        long l = System.currentTimeMillis();
        //new日期对象
        Date date = new Date(l);
        //转换提日期输出格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date);

        String api = "http://restapi.amap.com/v3/direction/transit/integrated?key=056d5aa58b7bb9c02c21d4f61305e3bf&origin=116.481028,39.989643&destination=116.434446,39.90816&city=%E5%8C%97%E4%BA%AC&cityd=%E5%8C%97%E4%BA%AC&strategy=0&nightflag=0";

        String str = apiService.httpRequest(api);

        String s = str.replaceAll("\\[]", "{}");
        //System.out.println(s);
        Way way = jsonToWay(s);
        /*Way way= (Way) str2Bean(str, Way.class);

        System.out.println(way);
        System.out.println(way.getRoute());

        String str2 = StringUtils.substringBefore(str, ":[");
        str2+="[";


        List<Transit> list = getList(str2);*/

        return ResponseEntity.ok(way);

    }

    public Way jsonToWay(String str) throws JsonProcessingException {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return MAPPER.readValue(str, new TypeReference<Way>() {
        });
    }

    public Object str2Bean(String jsonStr, Class<?> clazz) {
        Gson gson = new Gson();
        Object bean = gson.fromJson(jsonStr, clazz);
        return bean;
    }

    public List<Transit> getList(String jsonList){
        Gson gson1=new Gson();
        List<Transit> list= gson1.fromJson(jsonList, new TypeToken<List<Transit>>() {}.getType());
            for (Transit transit : list) {
            System.out.println(transit.toString());
            }
        return list;
    }

}
