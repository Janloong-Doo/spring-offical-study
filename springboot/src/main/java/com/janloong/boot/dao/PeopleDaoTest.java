package com.janloong.boot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleDaoTest {

    @Autowired
    PeopleDao peopleDao;

    @Test
    public void existsByName() {
        boolean janloong = peopleDao.existsByName("janloong");
        System.out.println(janloong);
    }
}