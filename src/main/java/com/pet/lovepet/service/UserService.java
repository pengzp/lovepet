package com.pet.lovepet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.lovepet.dao.UserMapper;
import com.pet.lovepet.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper,User> {

    @Autowired
    private UserMapper dao;
}
