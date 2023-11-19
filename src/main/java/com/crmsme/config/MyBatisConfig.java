package com.crmsme.config;

import com.crmsme.constant.CONSTANT_PROPERTIES;
import com.crmsme.security.CustomAlgorithm;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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


    @Bean
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();


        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3306/crmsme");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password(CustomAlgorithm.decrypt(CONSTANT_PROPERTIES.CRM_SME_ENCRYPTED_PASSWORD,CONSTANT_PROPERTIES.PASS_ENCRYPTION_KEY));
        return dataSourceBuilder.build();


    }
}