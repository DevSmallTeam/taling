package com.uxunchina.taling.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.bean
 * 数据返回对象封装
 * @date 2019/9/21 21:37
 */
@Data
public class DataResponse<T> {
    /**
     * 返回码 200 成功
     */
    private Integer code;
    /**
     * 返回消息说明
     */
    private String msg;
    /**
     * 数据总条数
     */
    private Integer count;
    /**
     * 数据对象
     */
    private List<T> data = new ArrayList<T>();

    public DataResponse(){

    }

    public DataResponse(Integer code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public DataResponse ok() {
        return new DataResponse(200, "ok", 0, null);
    }

    public DataResponse ok(String msg) {
        return new DataResponse(200, msg, 0, null);
    }

    public DataResponse okData(List<T> data) {
        return new DataResponse(200, "ok",0, data);
    }

    public DataResponse okData(Integer count, List<T> data) {
        return new DataResponse(200, "ok",count, data);
    }

    public DataResponse failure(String msg) {
        return new DataResponse(500, msg, 0,null);
    }

    public DataResponse response(Integer code,String msg) {
        return new DataResponse(code, msg, 0,null);
    }
}
