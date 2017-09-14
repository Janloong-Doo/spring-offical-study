package com.janloong.service.impl;

import com.janloong.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.janloong.domain.User;
import com.janloong.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public int insert(User pojo){
        return userDao.insert(pojo);
    }

    public int insertSelective(User pojo){
        return userDao.insertSelective(pojo);
    }

    public int insertList(List<User> pojos){
        return userDao.insertList(pojos);
    }

    public int update(User pojo){
        return userDao.update(pojo);
    }

    @Transactional
    public void updateAndInsert(User user){
        user.setAddress("shaolin tempale");
        update(user);
        insert(user);
    }
}
