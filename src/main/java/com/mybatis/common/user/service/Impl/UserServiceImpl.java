package com.mybatis.common.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.common.user.entity.User;
import com.mybatis.common.user.mapper.UserMapper;
import com.mybatis.common.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer userId) throws Exception {
        return userMapper.selectById(userId);

    }
}