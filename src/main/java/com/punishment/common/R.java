package com.punishment.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class R<T> {

    private T data;
    private Integer code;
    private String msg;

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static R<String> error(String msg) {
        R<String> r = new R<>();
        r.setData(null);
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

}
