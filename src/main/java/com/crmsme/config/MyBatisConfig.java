package com.crmsme.config;

import com.crmsme.constant.CONSTANT_PROPERTIES;
import com.crmsme.security.CustomAlgorithm;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {




    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }


    @Value("${database.driverClassName}")
    private String driverClassName ;



    @Value("${database.url}")
    private String url ;


    @Value("${database.username}")
    private String username ;

    @Value("${database.password}")
    private String password ;




    @Bean
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();


        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(CustomAlgorithm.decrypt(password,CONSTANT_PROPERTIES.PASS_ENCRYPTION_KEY));
        return dataSourceBuilder.build();

    }
}