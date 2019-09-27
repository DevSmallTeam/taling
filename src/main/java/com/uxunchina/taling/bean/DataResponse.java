package com.uxunchina.taling.bean;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.bean
 * 数据返回对象封装
 * @date 2019/9/21 21:37
 */
@Data
public class DataResponse extends HashMap<String,Object> {

    public DataResponse count(Long count) {
        this.put("count", count);
        return this;
    }

    public DataResponse code(int status) {
        this.put("code", status);
        return this;
    }

    public DataResponse code(HttpStatus status) {
        this.put("code", status.value());
        return this;
    }

    public DataResponse message(String message) {
        this.put("msg", message);
        return this;
    }

    public DataResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    public DataResponse success() {
        this.code(HttpStatus.OK);
        return this;
    }

    public DataResponse fail() {
        this.code(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    @Override
    public DataResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
