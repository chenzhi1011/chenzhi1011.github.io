package com.example.mywebserver;

import com.example.MyWebServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyWebServerApplicationTests implements CommandLineRunner {

    @Value("${spring.datasource.url}") // 如果未配置 my.property.key，则使用 "默认值"
    private String myProperty;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Property Value: " + myProperty);
    }

}
