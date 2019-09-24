package com.uxunchina.taling.configure;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.configure
 * @date 2019/9/21 20:59
 */
@Configuration
public class MybatisPlusConfigure {

    /**
     * 分页插件 解决 返回总条数为0的情况
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
