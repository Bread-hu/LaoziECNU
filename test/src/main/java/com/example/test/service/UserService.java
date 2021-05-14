package com.example.test.service;

import com.example.test.bean.User;

public interface UserService {

    public void register(User user);

    public void login(String username,String password);
}
