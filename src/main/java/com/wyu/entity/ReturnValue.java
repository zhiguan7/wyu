package com.wyu.entity;

import java.io.Serializable;

public class ReturnValue<T, S> implements Serializable {
    private static final long serialVersionUID = -1959544190118740608L;
    private int ret;
    private String msg;
    private T data1;
    private S date2;

    public ReturnValue(int ret, String msg, T data1, S date2) {
        this.ret = ret;
        this.msg = msg;
        this.data1 = data1;
        this.date2 = date2;
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

    public void setDate2(S date2) {
        this.date2 = date2;
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

    public S getDate2() {
        return date2;
    }
}
