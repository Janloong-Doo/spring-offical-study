package com.janloong.boot.dao;

import com.janloong.boot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInterfaceTest {

    @Autowired
    UserInterface userInterface;

    @Test
    public void queryAllByNameIs() {
        User janloong = userInterface.queryAllByNameIs("janloong");
        System.out.println(janloong);
    }

    @Test
    public void customTest() {
        //User user = userInterface.customTest("janloong");
        //System.out.println(user);
        //Pageable pageable = new QPageRequest(1, 10);
        //Page<User> all = userInterface.findAll(pageable);
        //System.out.println(all);

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path age = root.get("age");
                return criteriaBuilder.equal(age, 25);
            }
        };

        Pageable pageable = new QPageRequest(0, 10);
        List<User> all = userInterface.findAll(specification);
        System.out.println(all);
    }


    @Test
    public void customTest1() {

        User janloong = userInterface.customTest("janloong");
        System.out.println(janloong);
    }
}