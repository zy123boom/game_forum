package com.boomzy.service;

import java.util.Map;
import java.util.Set;

/**
 * 敏感词服务
 *
 * @author boomzy
 * @date 2020/4/3 9:22
 */
public interface SensitiveWordService {

    /**
     * 检查文字中是否包含敏感字符
     *
     * @param content 文字内容
     * @return 如果存在敏感字符，返回敏感词字符长度，不存在返回0
     */
    int checkSensitiveWord(String content);
}
