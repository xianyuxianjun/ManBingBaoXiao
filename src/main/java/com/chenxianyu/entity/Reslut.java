package com.chenxianyu.entity;

import lombok.Data;

@Data
public class Reslut {
    private Integer code;
    private String msg;
    private Object data;

    public Reslut(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Reslut Success() {
        return new Reslut(200,"成功",null);
    }

    public static Reslut Success(Object data) {
        return new Reslut(200,"成功",data);
    }

    public static Reslut Fail() {
        return new Reslut(500,"失败",null);
    }

    public static Reslut Fail(String msg) {
        return new Reslut(500,msg,null);
    }
}
