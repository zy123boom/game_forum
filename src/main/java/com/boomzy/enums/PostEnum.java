package com.boomzy.enums;

/**
 * 帖子枚举类
 *
 * @author boomzy
 * @date 2020/3/10 16:00
 */
public enum PostEnum {
    NOT_DELETED("00", "文章未删除"),
    DELETED("01", "文章已删除"),
    NOT_SENSITIVE("10", "文章非敏感"),
    IS_SENSITIVE("11", "文章敏感")
    ;

    private String code;
    private String message;

    PostEnum(String code, String message) {
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
