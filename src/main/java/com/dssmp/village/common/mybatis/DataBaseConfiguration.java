package com.dssmp.village.common.mybatis;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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

    private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);

    @Bean(name = "dataSource", destroyMethod = "close")
    @Primary
    public DataSource dataSource() {
        log.debug("Configruing Write DataSource");

        ComboPooledDataSource datasource = new ComboPooledDataSource();
        try {
            datasource.setJdbcUrl(propertyResolver.getProperty("dburl"));
            datasource.setDriverClass(propertyResolver.getProperty("driverClass"));
            datasource.setUser(propertyResolver.getProperty("username"));
            datasource.setPassword(propertyResolver.getProperty("password"));
            //datasource.setInitialSize(5);
            //datasource.setMaxActive(10);
            //datasource.setMinIdle(10);
            //datasource.setMaxIdle(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasource;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver=new RelaxedPropertyResolver(environment, "jdbc.");
    }
}
