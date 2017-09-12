package com.janloong.service;

import org.springframework.stereotype.Service;

/**
 * @author Janloong
 * @create 2017-09-12 14:51
 **/
@Service
public class LoongService1 {

    public String test1() {
        return "hello,janloong. this is service1 - test1";
    }


    public String test2(String s){
        return "receive the message :  " + s;
    }
}
