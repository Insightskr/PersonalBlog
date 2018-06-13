package com.ins.blog.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回信息类
 *
 * @author blue
 */
public class Msg {

    /**
     * 状态码 100-失败 200-成功
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 服务器要返回给浏览器的数据
     */
    private Map<String, Object> extend = new HashMap<>();

    public static Msg success() {
        return new Msg(200, "处理成功！");
    }

    public static Msg success(String msg) {
        return new Msg(200, msg);
    }

    public static Msg fail() {
        return new Msg(100, "处理失败！");
    }

    public static Msg fail(String msg) {
        return new Msg(100, msg);
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg(int code, String msg, Map<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extend = extend;
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

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}
