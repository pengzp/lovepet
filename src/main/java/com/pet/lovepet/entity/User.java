package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@TableName("t_user")
public class User {

    @Id
    private String id;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String address;

    private String avatar;

    private String description;

    private String email;

    private String mobile;

    private String nickName;

    private String password;

    private String sex;

    private Integer status;

    private Integer type;

    private String username;

    private Integer delFlag;

    private String departmentId;

    private String street;

    private String passStrength;

}