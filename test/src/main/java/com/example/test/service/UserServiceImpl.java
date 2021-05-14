package com.example.test.service;

import com.example.test.bean.User;
import com.example.test.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void register(User user){
        user.setId(UUID.randomUUID().toString());
        System.out.println(user.toString());
        userDao.saveUser(user);
    }

    @Override
    public void login(String username, String password) {
        if(password==userDao.getPwdByName(username)){

        }
        else {

        }
    }
}
