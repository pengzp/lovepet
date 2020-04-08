package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pet.lovepet.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_role")
@ApiModel(value = "角色表")
public class Role extends BaseEntity implements Serializable {

    /**
     * 角色代码
     */
    @ApiModelProperty(value = "角色代码")
    private String code;
    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String description;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;


}