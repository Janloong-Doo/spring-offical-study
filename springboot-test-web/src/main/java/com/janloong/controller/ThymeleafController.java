package com.janloong.controller;

import com.janloong.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Janloong
 * @create 2017-10-20 15:29
 **/
@Controller
public class ThymeleafController {

    @RequestMapping("/helloWord")
    public String  helloWord(Model model) {
        String[] num = {"1","2","3","4","5"};
        model.addAttribute("date", new Date());
        model.addAttribute("num", num);
        User user = new User();
        user.setName("Janloong Do_O");
        user.setAge("18");
        user.setAddress("china");
        user.setSex("男");
        model.addAttribute("user", user);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        User user1 = new User();
        user1.setName("Janloong Do_O");
        user1.setAge("18");
        user1.setAddress("china");
        user1.setSex("女");
        userList.add(user1);
        String[] sex={"男","女"};
        model.addAttribute("userList", user);
        model.addAttribute("sex", sex);
        model.addAttribute("customerName", "Janloong");
        return "helloWord";
    }

}
