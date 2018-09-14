package com.study.model;

import com.study.util.Constants;

import java.io.Serializable;

public class ResutModel implements Serializable {

    /**
     * 200 表示 成功  400 表示 失败
     */
    private Integer code;

    private String msg;

    private String errorInfo;

    public ResutModel(Integer code) {
        this.code = code;
    }

    public ResutModel(Integer code, String msg, String errorInfo) {
        this.code = code;
        this.msg = msg;
        this.errorInfo = errorInfo;
    }


    public static ResutModel SUCCESS() {
        ResutModel resut = new ResutModel(Constants.SUCCESS);
        return resut;
    }

    public static ResutModel FAIL(String msg, String errorInfo) {
        ResutModel resut = new ResutModel(Constants.FAIL, msg, errorInfo);
        return resut;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "ResutModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                '}';
    }
}
