package com.janloong.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Janloong
 * @date 2017-10-21 10:05
 **/
public class User {
    private String name;
    private String age;
    private String address;
    private String addres2s;
    private String sex;
    private Integer sex2;
    private LocalDateTime localDateTime;
    private BigDecimal bigDecimal;
    private BigDecimal bigDecimal2;
    private BigDecimal bigDecimal22;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
