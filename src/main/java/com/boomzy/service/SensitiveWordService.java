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
     * 初始化敏感词库
     *
     * @return
     */
    Map initKeyWord();

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建模型(trim树）
     *
     * @param keyWords 敏感词集合
     * @return
     */
    Map addSensitiveWordToHashMap(Set<String> keyWords);

    /**
     * 从数据库获取敏感词
     *
     * @return
     */
    Set<String> getSensitiveWords();

    /**
     * 判断文字内容是否包含敏感字符
     *
     * @param content 文字内容
     * @return
     */
    boolean isContainSensitiveWord(String content);

    /**
     * 获取文字内容中的敏感词
     *
     * @param content 文字内容
     * @return
     */
    Set<String> getSensitiveWord(String content);

    /**
     * 检查文字中是否包含敏感字符
     *
     * @param content 文字内容
     * @param beginIndex
     * @return 如果存在敏感字符，返回敏感词字符长度，不存在返回0
     */
    public int checkSensitiveWord(String content, int beginIndex);
}
