package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyWebServerApplication.class, args);
    }

}
