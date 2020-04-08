package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pet.lovepet.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
@ApiModel(value = "用户表")
public class User extends BaseEntity implements Serializable {

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String username;
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String loginName;
    /**
     * 盐值
     */
    @ApiModelProperty(value = "盐值")
    private String salt;
    /**
     * 被锁日期
     */
    @ApiModelProperty(value = "被锁日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lockedDate;

    /**
     * 是否被锁0：未锁 1：被锁
     */
    @ApiModelProperty(value = "是否被锁0：未锁 1：被锁")
    private Boolean locked = Boolean.FALSE;

}