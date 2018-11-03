package com.imc.configuration;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author luoly
 * @date 2018/11/3 12:03
 * @description
 */
@Configuration
public class DBUtilsConfiguration {

    @Bean
    public QueryRunner queryRunner(@Qualifier("druidDataSource") DataSource dataSource) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}
