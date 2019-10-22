package com.uxunchina.taling.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.common.properties
 * @date 2019/9/27 09:58
 */
@Data
@SpringBootConfiguration
@PropertySource(value = "classpath:swagger.properties",encoding = "utf-8")
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}
