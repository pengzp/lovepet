package com.pet.lovepet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.lovepet.dao.RoleMapper;
import com.pet.lovepet.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    @Autowired
    private RoleMapper dao;
}
