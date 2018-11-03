package com.imc.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author luoly
 * @date 2018/10/22 11:52
 * @description
 */

@Configuration
@PropertySource(value = "classpath:druid.properties")
public class DruidConfiguration {

    private static final Log log = LogFactory.getLog(DruidConfiguration.class);

    @Bean(destroyMethod = "close", initMethod = "init",name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        log.info("druid连接池已创建-->" + druidDataSource);
        return druidDataSource;
    }

}
