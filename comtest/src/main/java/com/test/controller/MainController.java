package com.test.controller;

import com.test.domain.FpbLg;
import com.test.domain.FpbTz;
import com.test.service.FpbService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MainController {

    @Autowired
    FpbService fpbService;

    //查询库存
    @RequestMapping(value="/api/queryFpbTz",method = RequestMethod.GET)
    public String queryForFpbTz(){
        return  fpbService.queryFpbStocks();
    }
    //购票记录
    @RequestMapping(value="/api/queryFpbLgs",method = RequestMethod.GET)
    public String queryForFpbLg(){
        return  fpbService.queryFpbLgs();
    }

    //添加购票记录
    @RequestMapping(value="/api/addFpbLg",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveFpbLg(@RequestBody JSONObject obj){
        FpbLg fpbLg=(FpbLg) JSONObject.toBean(obj,FpbLg.class);
        fpbLg.setFPSJ(new Date());
        fpbLg.setYWBZ(1);
        fpbService.saveFpbLg(fpbLg);
        return true;
    }

    @RequestMapping(value="/api/updateFpbTz",method = RequestMethod.POST)
    //@RequestBody
    public boolean updateFpbTz(@RequestBody JSONObject obj){
        FpbTz fpbTz=(FpbTz)JSONObject.toBean(obj,FpbTz.class);

        return true;
    }

    @RequestMapping(value="/api/getZh",method = RequestMethod.GET)
    public String getAccount(){
        return fpbService.queryKpzh();
    }

//    @RequestMapping(value = "/api/queryFpbTz",method = RequestMethod.GET)
//    public String queryFpbTz(){
//        return fpbService.queryKpbTzs();
//    }



}
