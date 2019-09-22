package com.uxunchina.taling.configure;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.parser.ISqlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.configure
 * @date 2019/9/21 20:59
 */
@Configuration
public class MybatisPlusConfigure {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
