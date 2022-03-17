package com.dh.appproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.dh.appproject.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class AppProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppProjectApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
