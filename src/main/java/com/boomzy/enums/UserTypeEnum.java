package com.boomzy.enums;

/**
 * 用户权限枚举类
 *
 * @author boomzy
 * @date 2020/2/27 12:13
 */
public enum UserTypeEnum {
    NORMAL_USER("01", "普通用户"),
    ADMINISTRATOR("02", "管理员"),
    TOURIST("03", "游客"),
    INVALID("04", "已失效")
    ;

    private String code;
    private String message;

    UserTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
