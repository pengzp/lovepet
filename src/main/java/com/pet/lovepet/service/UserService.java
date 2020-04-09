package com.pet.lovepet.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.lovepet.dao.mapper.UserMapper;
import com.pet.lovepet.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: lovepet
 * @description:
 * @author: Mr.peng
 * @create: 2020-04-01 23:03
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Autowired
    private UserMapper userMapper;

    public User findUserByLoginName(String name){
        return userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getLoginName,name));
    }
}
