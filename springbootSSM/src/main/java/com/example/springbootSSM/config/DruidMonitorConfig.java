package com.example.springbootSSM.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置druid监控
 */
@Configuration
public class DruidMonitorConfig {
    /**
     * 注册ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean getRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        bean.addInitParameter("allow", "127.0.0.1");
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "123456");
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }

    /**
     * 注册FilterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean getFilterBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusion","*.js,*.gif,*.jpg,*.png,*.css,/druid/*");
        return filter;
    }

}
