package com.janloong.service;

import com.janloong.domain.User;

import java.util.List;

public interface UserService {

    int insert(User pojo);

    int insertSelective(User pojo);

    int insertList(List<User> pojos);

    int update(User pojo);
}
