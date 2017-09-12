package com.janloong.service.impl;

import com.janloong.service.LoongService2;
import org.springframework.stereotype.Service;

/**
 * @author Janloong
 * @create 2017-09-12 17:27
 **/
@Service
public class LoongServiceImpl2 implements LoongService2 {

    public String test1(String msg) {
        return "service receive msg :  " + msg;
    }
}
