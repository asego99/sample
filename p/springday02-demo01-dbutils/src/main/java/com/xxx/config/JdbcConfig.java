package com.xxx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName JdbcConfig
 * @Description
 * @Date 2022-08-02 14:26
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Value("${jdbc.driverclass}")
    private String driverclass;

    @Value("${jdbc.jdbcurl}")
    private String jdbcurl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverclass);
        dataSource.setJdbcUrl(jdbcurl);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
