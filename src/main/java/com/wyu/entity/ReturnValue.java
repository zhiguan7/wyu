package com.wyu.entity;

import java.io.Serializable;

public class ReturnValue<T> implements Serializable {
    private static final long serialVersionUID = -1959544190118740608L;
    private int ret;
    private String msg;
    private T data1;

    public ReturnValue(int ret, String msg, T data1) {
        this.ret = ret;
        this.msg = msg;
        this.data1 = data1;
    }

    public ReturnValue() {
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData1(T data1) {
        this.data1 = data1;
    }

    public int getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public T getData1() {
        return data1;
    }

}
