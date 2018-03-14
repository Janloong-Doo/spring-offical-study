package com.janloong.boot.dao;

import com.janloong.boot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    User queryAllByNameIs(String name);


    @Query(value = "SELECT name,age FROM User WHERE name =?1")
    User customTest(String name);


}
