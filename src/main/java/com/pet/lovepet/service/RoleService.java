package com.pet.lovepet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.lovepet.dao.mapper.RoleMapper;
import com.pet.lovepet.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/4/9 9:37
 * @Description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getCurrentRole(Map map){
        return roleMapper.getAll(map);
    }
}
