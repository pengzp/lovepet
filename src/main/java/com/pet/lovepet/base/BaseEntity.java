package com.pet.lovepet.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /**
     * 是否有效
     */
    private Integer deleteFlag = 0;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATED_TIME",update = "SYSDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}
