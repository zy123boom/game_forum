package com.boomzy.enums;

/**
 * 敏感词/敏感帖
 *
 * @author boomzy
 * @date 2020/4/2 15:45
 */
public enum SensitiveEnum {
    NOT_SENSITIVE_POST("10", "非敏感帖子"),
    SENSITIVE_POST("11", "敏感帖子"),
    NOT_HIT_SENSITIVE_WORD("00", "未命中敏感词"),
    HIT_SENSITIVE_WORD("01", "命中敏感词")
    ;

    private String code;
    private String message;

    SensitiveEnum(String code, String message) {
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
