package com.uxunchina.taling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uxunchina.*.mapper")
public class TalingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalingApplication.class, args);
    }

}
