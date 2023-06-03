package springboot.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int code;
    private String msg;
    private Map<String, Object> extend = new HashMap<>();

    public static Msg success() {
        Msg msg1 = new Msg();
        msg1.setCode(200);
        msg1.setMsg("ok");
        return msg1;
    }

    public static Msg error() {
        Msg msg1 = new Msg();
        msg1.setCode(400);
        msg1.setMsg("error");
        return msg1;
    }

    public Msg add(String key, Object value) {
        extend.put(key, value);
        return this;
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