package com.uxunchina.taling;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uxunchina.taling.*.mapper*")
@EnableApolloConfig
public class TalingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalingApplication.class, args);
    }

}
