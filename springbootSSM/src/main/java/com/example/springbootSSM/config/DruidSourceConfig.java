package com.example.springbootSSM.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 第三方druid数据库连接池的配置，交给spring管理
 */
@Configuration
@Primary
public class DruidSourceConfig extends DataSourceProperties {
    @Value("${spring.datasource.url}")
    private String dburl;
    @Value("${spring.datasource.data-username}")
    private String username;
    @Value("${spring.datasource.data-password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassname;
    @Value("${spring.datasource.initialSize}")
    private int  initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.maxActive}")
    private int maiActive;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.filters}")
    private String filters;

    /**
     * 注册datasource
     * @return
     * @throws SQLException
     */
    @Bean(name = "druidDataSource")
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dburl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassname);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxActive(maiActive);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setFilters(filters);
        return dataSource;
    }

}
