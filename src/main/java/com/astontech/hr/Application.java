package com.astontech.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Adrian.Flak on 6/28/2017.
 */
@SpringBootApplication
public class Application {

//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
//    @Value("${spring.datasource.username}")
//    private String datasourceUsername;
//    @Value("${spring.datasource.password}")
//    private String datasourcePassword;
//    @Value("${spring.datasource.driver-class-name}")
//    private String datasourceDriverClassName;
//
//    @Bean
//    public DataSource dataSource(){
//        DataSource ds = new DataSource();
//        ds.setDriverClassName(datasourceDriverClassName);
//        ds.setUrl(datasourceUrl);
//        ds.setUsername(datasourceUsername);
//        ds.setPassword(datasourcePassword);
//
//        return ds;
//    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}