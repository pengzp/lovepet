package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pet.lovepet.base.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class User extends BaseEntity implements Serializable {

    /**
     * 描述
     */
    private String description;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 姓名
     */
    private String username;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 被锁日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lockedDate;

    /**
     * 是否被锁0：未锁 1：被锁
     */
    private Boolean locked = Boolean.FALSE;

}