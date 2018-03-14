package com.janloong.boot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Janloong
 * @date 2017-10-21 10:05
 **/
@Entity
public class User {

    @Id
    private String userId;

    private String name;
    private String age;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
