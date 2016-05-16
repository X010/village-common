package com.dssmp.village.common.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by jeffrey on 11/10/15.
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    private static Logger LOG = LoggerFactory.getLogger(DataBaseConfiguration.class);

    @Primary
    @Bean(name = "dataSource", destroyMethod = "close")
    public DataSource dataSource() {
        LOG.debug("Configruing Write DataSource");
        DruidDataSource datasource = new DruidDataSource();
        try {
            datasource.setUrl(propertyResolver.getProperty("dburl"));
            datasource.setDriverClassName(propertyResolver.getProperty("driverClass"));
            datasource.setUsername(propertyResolver.getProperty("username"));
            datasource.setPassword(propertyResolver.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasource;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "jdbc.");
    }
}
