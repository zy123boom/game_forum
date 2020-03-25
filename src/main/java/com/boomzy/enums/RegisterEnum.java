package com.boomzy.enums;

/**
 * 用户注册枚举类
 *
 * @author boomzy
 * @date 2020/2/27 12:12
 */
public enum RegisterEnum {
    SUCCESS(1, "注册成功"),
    REGISTER_FAIL(0, "注册失败，用户信息不合法"),
    SYSTEM_ERROR(-1, "注册失败，系统错误")
    ;

    private Integer code;
    private String message;

    RegisterEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
