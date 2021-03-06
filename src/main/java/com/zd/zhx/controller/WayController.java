package com.zd.zhx.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.zd.zhx.pojo.Transit;
import com.zd.zhx.pojo.Way;
import com.zd.zhx.service.ApiService;
import com.zd.zhx.service.WayService;
import com.zd.zhx.pojo.FavoriteWay;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/way")
public class WayController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private WayService wayService;

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

        String s = str.replaceAll("\\[]", "null");
        //System.out.println(s);
        Way way = jsonToWay(s);
        //System.out.println(way.getRoute().getTransits().get(0).getSegments().get(0).getWalking().getSteps().get(5));
        /*Way way= (Way) str2Bean(str, Way.class);

        System.out.println(way);
        System.out.println(way.getRoute());

        String str2 = StringUtils.substringBefore(str, ":[");
        str2+="[";


        List<Transit> list = getList(str2);*/

        return ResponseEntity.ok(way);

    }

    @PostMapping("/saveWay")
    public ResponseEntity<Boolean> saveFavoriteWay(String username,String pathStart,String pathEnd,String startPlace,String endPlace){
        if (username == null || pathStart == null || pathEnd == null || startPlace == null || endPlace == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else if (!wayService.checkFavoriteWay(username, startPlace, endPlace)){
                wayService.saveFavoriteWay(username, pathStart, pathEnd,startPlace,endPlace);
                return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/getFavorites")
    public ResponseEntity<List<FavoriteWay>> getFavoriteWay(String username){

        List favoriteWays = wayService.getFavoriteWays(username);
        return ResponseEntity.ok(favoriteWays);
    }

    @PostMapping("/delFavorites")
    public ResponseEntity<HttpStatus> delFavoriteWay(String startPlace,String endPlace){
        try {
            wayService.delFavoriteWay(startPlace, endPlace);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public Way jsonToWay(String str) throws JsonProcessingException {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return MAPPER.readValue(str, Way.class);
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
