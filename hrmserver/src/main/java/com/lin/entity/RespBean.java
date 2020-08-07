package com.lin.entity;

import lombok.Data;

@Data
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
