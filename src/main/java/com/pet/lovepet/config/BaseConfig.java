package com.pet.lovepet.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/4/9 10:18
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.pet.lovepet.dao.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class BaseConfig {

    @Bean(name = "DataSource")
    public DruidDataSource DataSource(DruidConfig dbConfig) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbConfig.getDriverClassName());
        druidDataSource.setUrl(dbConfig.getUrl());
        druidDataSource.setUsername(dbConfig.getUserName());
        druidDataSource.setPassword(dbConfig.getPassword());
        druidDataSource.setInitialSize(dbConfig.getInitialSize());
        druidDataSource.setMinIdle(dbConfig.getMinIdle());
//        配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
        druidDataSource.setUseUnfairLock(true);
        druidDataSource.setMaxActive(dbConfig.getMaxActive());
        druidDataSource.setMaxWait(dbConfig.getMaxWait());
//        配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenConnectErrorMillis(dbConfig.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dbConfig.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dbConfig.getValidationQuery());
        druidDataSource.setFilters("stat,slf4j");
//        druidDataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=10000");
//        druidDataSource.setRemoveAbandoned(false);
        StatFilter statFilter = new StatFilter();
//        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(10000L);
        statFilter.setLogSlowSql(true);
        ArrayList<Filter> objects = new ArrayList<>();
        objects.add(statFilter);
        druidDataSource.setProxyFilters(objects);


        Properties properties = new Properties();
//        properties.setProperty("config.decrypt", "true");
        //properties.setProperty("key", dbConfig.getPublicKey());
        properties.setProperty("password", dbConfig.getPassword());
        druidDataSource.setConnectProperties(properties);
        try {
            druidDataSource.setPasswordCallbackClassName("com.bigita.servicemanagement.config.DbPasswordCallback");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return druidDataSource;
    }


//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }

    /**
     * 功能描述:(sql会话工厂)
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "SqlSessionFactory")
    @Primary
    public SqlSessionFactory SqlSessionFactory(@Qualifier("DataSource") DataSource dataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*Mapper.xml"));
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("other");
        Interceptor[] interceptors = {page};
        bean.setPlugins(interceptors);
        //分页插件
//        Properties properties = new Properties();
//        properties.setProperty("helperDialect", "mysql");
//        Interceptor interceptor = new PageInterceptor();
//        interceptor.setProperties(properties);
//        bean.setPlugins(new Interceptor[] {interceptor});

        return bean.getObject();
    }

    /**
     * 功能描述:(事物管理)
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
