package com.pet.lovepet.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: lovepet
 * @description:
 * @author: Mr.peng
 * @create: 2020-04-08 19:40
 **/
@Data
public class BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "唯一标识")
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 是否有效
     */
    @ApiModelProperty(value = "删除标志 默认0")
    private Integer deleteFlag = 0;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "UPDATE_TIME",update = "SYSDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
