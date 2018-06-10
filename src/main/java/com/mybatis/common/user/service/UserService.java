package com.mybatis.common.user.service;

import com.mybatis.common.user.entity.User;

public interface UserService {
    User selectUserById(Integer userId) throws Exception;
}