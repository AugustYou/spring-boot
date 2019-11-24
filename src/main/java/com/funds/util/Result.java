package com.funds.util;

/**
 * @author tuzhijin
 * @version Id: Result.java, v 0.1 2019/11/24 23:39 tuzhijin Exp $$
 */
public class Result {

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.code = 200;
        this.data = data;
    }

    public Result(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
