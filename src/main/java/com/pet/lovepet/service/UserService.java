package com.pet.lovepet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.lovepet.dao.mapper.UserMapper;
import com.pet.lovepet.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lovepet
 * @description:
 * @author: Mr.peng
 * @create: 2020-04-01 23:03
 **/
@Slf4j
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;
}
