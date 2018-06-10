package com.mybatis.common.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.common.user.entity.User;
import com.mybatis.common.user.service.UserService;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView getIndex() throws Exception{
        ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(22);
        mav.addObject("user", user);
        System.out.println("controller");
        return mav;
    }
}