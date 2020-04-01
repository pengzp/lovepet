package com.pet.lovepet.controller;

import com.pet.lovepet.dao.UserMapper;
import com.pet.lovepet.entity.User;
import com.pet.lovepet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    @ResponseBody
    public List<User> getUserList(){

        List<User> users = userService.list();

        return users;
    }
}
