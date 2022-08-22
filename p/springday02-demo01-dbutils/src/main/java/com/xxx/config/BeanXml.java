package com.xxx.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountConfig
 * @Description
 * @Date 2022-08-02 13:35
 */
@Configuration
@ComponentScan("com.xxx")//包扫描
@Import(JdbcConfig.class)
public class BeanXml {
    @Bean
    public QueryRunner qr(DataSource dataSource) {
        QueryRunner qr = new QueryRunner(dataSource);

        return qr;
    }
}
