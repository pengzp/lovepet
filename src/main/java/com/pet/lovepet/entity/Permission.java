package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_permission")
public class Permission implements Serializable {

    private String id;

    private String createBy;

    private Date createTime;

    private Integer delFlag;

    private String updateBy;

    private Date updateTime;

    private String buttonType;

    private String component;

    private String description;

    private String icon;

    private Integer level;

    private String name;

    private String parentId;

    private String path;

    private Boolean showAlways;

    private BigDecimal sortOrder;

    private Integer status;

    private String title;

    private Integer type;

    private String url;

}