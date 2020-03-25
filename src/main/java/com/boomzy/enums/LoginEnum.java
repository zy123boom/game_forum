package com.boomzy.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录枚举类
 *
 * @author boomzy
 * @date 2020/2/26 17:27
 */

public enum LoginEnum {
    SUCCESS(1, "登录成功"),
    LOGIN_FAIL(0, "登录失败，用户名密码错误或不合法"),
    SYSTEM_ERROR(-1, "登录失败，系统错误"),
    USER_IN_DARK(2, "登录失败，用户已被封号")
    ;

    private Integer code;
    private String message;

    LoginEnum(Integer code, String message) {
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
