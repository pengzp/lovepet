package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pet.lovepet.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user_role")
@ApiModel(value = "用户角色表")
public class UserRole extends BaseEntity implements Serializable {
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ApiModelProperty(value = "用户ID")
    private String userId;

}