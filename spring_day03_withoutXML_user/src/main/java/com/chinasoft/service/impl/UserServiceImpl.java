package com.chinasoft.service.impl;

import com.chinasoft.domain.User;
import com.chinasoft.mapper.UserMapper;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;



    public List<User> findAll() {
        return mapper.findAll();
    }
}
