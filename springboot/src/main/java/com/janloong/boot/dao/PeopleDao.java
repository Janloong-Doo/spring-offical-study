package com.janloong.boot.dao;


import com.janloong.boot.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Repository
public interface PeopleDao extends JpaRepository<People, String> {

    boolean existsByName(String name);
}
