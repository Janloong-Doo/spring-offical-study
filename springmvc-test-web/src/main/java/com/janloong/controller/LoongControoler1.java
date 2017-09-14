package com.janloong.controller;

import com.janloong.domain.User;
import com.janloong.service.LoongService1;
import com.janloong.service.LoongService2;
import com.janloong.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Janloong
 * @create 2017-09-12 14:44
 **/
@Controller
public class LoongControoler1 {

    @Resource
    private LoongService1 loongService1;
    @Resource
    private LoongService2 loongService2;
    @Resource
    private UserService userService;

    @RequestMapping("/test1")
    public @ResponseBody
    String test1() {
        return "hello,janloong";
    }

    @RequestMapping("/test2/{name}")
    public @ResponseBody
    String test2(@PathVariable("name") String s) {
        return " receive msg : " + s;
    }

    @RequestMapping("/test3")
    public @ResponseBody
    String test3(String msg) {
        return loongService1.test2(msg);
    }

    @RequestMapping("/test4")
    public @ResponseBody
    String test4(String msg) {
        return loongService2.test1(msg);
    }

    @RequestMapping("/test5")
    public @ResponseBody
    User test5(User user) {
        int insert = userService.insert(user);
        return user;
    }
}
