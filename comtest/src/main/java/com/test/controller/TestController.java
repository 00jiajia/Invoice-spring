package com.test.controller;

//import com.test.cacheRepository.RedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/redis")
public class TestController {
//    @Autowired
//    private RedisImpl redisImpl;
//
//    @RequestMapping("/add")
//    public String setRedis(String id,String name){
//        redisImpl.set(id,name);
//        return "redis设置成功"+"id="+id+" name="+name;
//    }
//
//    @RequestMapping("/select")
//    public String getRedis(String id){
//        return "redis获得值成功"+"id="+redisImpl.get(id);
//    }
//
//
//    @RequestMapping("/mvc1")
//    public ModelAndView mvc1() {
//        return new ModelAndView("index");
//    }
}
