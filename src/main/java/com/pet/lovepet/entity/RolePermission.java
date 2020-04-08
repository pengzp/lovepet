package com.pet.lovepet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_role_permission")
public class RolePermission implements Serializable {

    private String id;

    private String createBy;

    private Date createTime;
    
    private Integer delFlag;

    private String updateBy;

    private Date updateTime;

    private String permissionId;

    private String roleId;

}