package org.chenfeng.taling.antiReplay;

import java.lang.annotation.*;

/**
 * @desc 定义一个不重复提交的注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableAntiReplay {
    /**
     * 防重复操作限时标记数值（存储redis限时标记数值）
     */
    String value() default "value" ;

    /**
     * 防重复操作过期时间（借助redis实现限时控制）
     */
    long expireSeconds() default 10;
}
