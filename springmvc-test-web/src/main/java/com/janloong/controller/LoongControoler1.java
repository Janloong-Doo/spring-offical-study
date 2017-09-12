package com.janloong.controller;

import com.janloong.service.LoongService1;
import com.janloong.service.LoongService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Janloong
 * @create 2017-09-12 14:44
 **/
@Controller
public class LoongControoler1 {

    @Autowired
    private LoongService1 loongService1;
    @Autowired
    private LoongService2 loongService2;

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
}
