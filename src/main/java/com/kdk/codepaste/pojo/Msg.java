package com.kdk.codepaste.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Msg {
    private Msg() {}

    private Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //信息的代码：200成功 400失败
    private int code;
    //返回信息的提示
    private String msg;
    //返回的信息
    private Map<String, Object> body = null;

    //成功返回代码200
    public static Msg success(String msg) {
        return new Msg(200, msg);
    }
    //失败返回代码400
    public static Msg fail(String msg) {
        return new Msg(400, msg);
    }

    //可链式添加
    public Msg add(String key, Object value) {
        if(body == null) {
            body = new HashMap<>();
        }
        body.put(key, value);
        return this;
    }

}