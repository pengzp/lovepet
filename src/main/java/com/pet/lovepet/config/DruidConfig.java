package com.pet.lovepet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/4/9 10:22
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource")
@Component
public class DruidConfig {

    private String url;

    private String userName;

    private String password;

    private String driverClassName;

    private Integer initialSize;

    private Integer minIdle;

    private Integer maxActive;

    private Integer maxWait;

    private Long timeBetweenEvictionRunsMillis;

    private Long minEvictableIdleTimeMillis;

    private String validationQuery;

    //private String publicKey;
}
