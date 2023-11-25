package com.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.WorkResource.service", "com.front.controller","com.WorkResource.config"})
@MapperScan("com.WorkResource.mapper")
public class frontApplication {
    public static void main(String[] args) {
        SpringApplication.run(frontApplication.class, args);
    }
}
