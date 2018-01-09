package com.janloong.controller;

import com.janloong.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/a")
    public @ResponseBody String greeting() {
        return "Hello World ， janloong";
    }


    @RequestMapping("test1")
    public @ResponseBody String getdd(@RequestBody String user){
          logger.info("\n-HomeController-getdd："+"\n"
                          +"user:"+ user +"\n"
                          );
        return user;
    }
    @RequestMapping("test2")
    public @ResponseBody User getdd2(@RequestBody User user){
        logger.info("\n-HomeController-getdd："+"\n"
                +"user:"+ user +"\n"
        );
        return user;
    }
}
