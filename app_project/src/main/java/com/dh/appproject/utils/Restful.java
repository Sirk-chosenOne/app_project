package com.dh.appproject.utils;

public class Restful {
    /**
     * RestControllerHelper的toJson常量
     */
    private static final String RESULT_CODE = "code";
    private static final String RESULT_MSG = "msg";
    private static final String RESULT_DATA = "data";

    /**
     * 200: 成功。
     * 401: 当前请求需要用户验证。
     * 403：权限错误。
     * 404: 请求的资源未找到。
     * 408：请求超时。
     */
    public static final int SUCCESS = 200;
    public static final int UNLOGIN = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int TIMEOUT = 408;

    /**
     *  code: 状态码
     *  msg: 状态码消息
     *  data: 数据
     */
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Restful(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
