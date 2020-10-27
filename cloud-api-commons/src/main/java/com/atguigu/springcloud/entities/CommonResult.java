package com.atguigu.springcloud.entities;
/*
 *  通用返回结果集
 * */

/**
 * @author Administrator
 */
public class CommonResult<T> {

    /**
     * 编码
     */
    private Integer code;

    /**
     *信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;


    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
