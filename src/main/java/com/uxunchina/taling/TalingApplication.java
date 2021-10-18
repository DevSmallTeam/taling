package com.uxunchina.taling;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.uxunchina.taling.*.mapper*")
@EnableApolloConfig
@Slf4j
public class TalingApplication {

    public static void main(String[] args) {
        try {
            SpringApplication app = new SpringApplication(TalingApplication.class);
            ConfigurableApplicationContext con = app.run(args);
            Environment env = con.getEnvironment();
            String protocol = "http";
            if (env.getProperty("server.ssl.key-store") != null) {
                protocol = "https";
            }
            log.info("\n----------------------------------------------------------\n\t" +
                            "Application '{}' is running! Access URLs:\n\t" +
                            "Local: \t\t{}://localhost:{}\n\t" +
                            "External: \t{}://{}:{}\n\t" +
                            "Profile(s): \t{}\n----------------------------------------------------------",
                    env.getProperty("spring.application.name"),
                    protocol,
                    env.getProperty("server.port"),
                    protocol,
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"),
                    env.getActiveProfiles());
        } catch (UnknownHostException e) {
            log.error("项目启动异常", e);
        }
    }

}
