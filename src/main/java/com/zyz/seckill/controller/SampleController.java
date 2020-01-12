//package com.zyz.seckill.controller;
//
//import com.zyz.seckill.pojo.User;
//import com.zyz.seckill.redis.UserKey;
//import com.zyz.seckill.result.Result;
//import com.zyz.seckill.redis.RedisService;
//import com.zyz.seckill.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class SampleController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RedisService redisService;
//
//    @RequestMapping("/hello")
//    public String hello(Model model){
//        model.addAttribute("name","zyz");
//        return "hello";
//
//    }
//
//    @ResponseBody
//    @RequestMapping("/db/get")
//    public Result<User> dbGet(){
////        Integer id = 1;
//        User user = userService.getById(1);
//
//        return Result.success(user);
//    }
//    @ResponseBody
//    @RequestMapping("/db/tx")
//    public Result<Boolean> dbTx(){
//        userService.tx();
//        return Result.success(true);
//
//    }
//
//    @ResponseBody
//    @RequestMapping("/redis/tx")
//    public Result<User> redisGet(){
//        User user = redisService.get(UserKey.getById,""+1, User.class); //UserKey:id1
//        return Result.success(user);
//
//    }
//    @ResponseBody
//    @RequestMapping("/redis/set")
//    public Result<Boolean> redisSet(){
//        User user = new User();
//        user.setId(1);
//        user.setName("test");
//        boolean key1 = redisService.set(UserKey.getById,""+1, user);//UserKey:id1
////        String key2 = redisService.get(UserKey.getById,"key2", String.class);
//        return Result.success(true);
//
//    }
//}
