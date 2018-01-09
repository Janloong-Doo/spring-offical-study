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
        //forTest();
        //stringTest();
        //calc(15436,1000);
        //sw("orderNotify");
        testVoid();
        System.out.println("失败");
    }

    private static void stringTest() {

        String ss = "hello %s";

        System.out.println(String.format(ss, "fycdsdasdg"));
    }

    private static void forTest() {
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
            System.out.println("s1:----------" + s1);
            System.out.println("s2:----------" + s2);
            u.setCardId(s2);
            int i = new Random().nextInt(9);
            System.out.println("------" + i + "------");
            u.setAddress(i + "");
            System.out.println("----------tag----------");
        }
        System.out.println("u--" + list);
    }

    private static void calc(int a, int b) {

        double aa = Double.valueOf(a);
        double bb = Double.valueOf(b);
        double c = aa / bb;
        c = (double) ((int) (c * 100)) / 100;

        System.out.println(c + "");
    }

    private static void sw(String type) {

        switch (type) {
            case "custom":
                //自定义消息发送
                System.out.println("1");
                break;
            case "orderNotify":
                //订单消息通知
                System.out.println("2");

                break;
            default:
                System.out.println("3");
                break;
            //throw new BusinessException("不符合的模版消息通知类型");
        }
    }

    private static void testVoid(){
        System.out.println("中断");
        return ;

    }
}
