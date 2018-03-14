package com.janloong.boot.domain;


import javax.persistence.*;

/**
 * @author <a href ="mailto: janloongdoo@gmail.com">Janloong</a>
 * @date 2018-03-07 16:01
 */
@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue
    @Column(name = "people_id")
    private String peopleId;

    private String name;
    private String age;

}
