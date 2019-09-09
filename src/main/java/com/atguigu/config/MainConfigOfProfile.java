package com.atguigu.config;

import com.atguigu.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

@PropertySource("classpath:/db.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String driverClass;

    private StringValueResolver valueResolver;

    @Bean
    public Yellow yellow()
    {
        return new Yellow();
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd)
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:msql://localhost:3306/dev");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd)
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:msql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:msql://localhost:3306/prod");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver=stringValueResolver;
        driverClass=valueResolver.resolveStringValue("${db.driverClass}");
    }
}
