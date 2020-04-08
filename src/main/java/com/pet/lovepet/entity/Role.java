package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pet.lovepet.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_role")
public class Role extends BaseEntity implements Serializable {

    /**
     * 角色代码
     */
    private String code;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 角色名称
     */
    private String name;


}