package com.wyu.entity;

import java.io.Serializable;

public class ReturnValue<T> implements Serializable {
    private static final long serialVersionUID = -1959544190118740608L;
    private int ret;
    private String msg;
    private T data;

    public ReturnValue(int ret, String msg, T data) {
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public ReturnValue() {
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData1(T data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public T getData1() {
        return data;
    }

}
