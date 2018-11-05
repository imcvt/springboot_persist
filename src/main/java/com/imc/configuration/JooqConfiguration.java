package com.imc.configuration;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * @author luoly
 * @date 2018/11/5 09:43
 * @description
 */

@Configuration
public class JooqConfiguration {
    @Bean
    public DSLContext dslContext(@Qualifier("druidDataSource") DataSource dataSource) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        DataSourceTransactionManager txMgr = new DataSourceTransactionManager(dataSource);
        org.jooq.Configuration configuration = new DefaultConfiguration().set(new DataSourceConnectionProvider(proxy))
                .set(new SpringTransactionProvider(txMgr)).set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    }
}
