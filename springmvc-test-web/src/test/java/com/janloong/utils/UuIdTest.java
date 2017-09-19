package com.janloong.utils;

import com.janloong.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Janloong
 * @create 2017-09-19 10:07
 **/
public class UuIdTest {

    public static void main(String[] args) {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        user.setName("a");
        List<User> list = new ArrayList<>();
        list.add(user);

        user2.setName("b");
        list.add(user2);
        user3.setName("c");
        list.add(user3);
        for (User u : list) {
            String s1 = UUID.randomUUID().toString();
            String s2 = UUID.randomUUID().toString();
            System.out.println("s1:----------"+s1);
            System.out.println("s2:----------"+s2);
            u.setCardId(s2);
            int i = new Random().nextInt(9);
            System.out.println("------"+i+"------");
            u.setAddress(i+"");
            System.out.println("----------tag----------");
        }
        System.out.println("u--"+list);
    }

}
