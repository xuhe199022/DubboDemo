package com.xcc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class PrioviderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrioviderServerApplication.class, args);
    }

}
