package com.boomzy.util;

import com.boomzy.dao.AdminDao;
import com.boomzy.service.SensitiveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 敏感词初始化
 *
 * @author boomzy
 * @date 2020/4/3 9:32
 */
@Component
public class SensitiveWordInitUtils {

    @Autowired
    private AdminDao adminDao;

    // 初始化map
    private Map initSensitiveWordMap;
    // 最终map
    private Map sensitiveWordMap;

    /**
     * 初始化敏感词库
     *
     * @return
     */
    public Map initKeyWord() {
        try {
            // 读取敏感词库
            Set<String> keyWordSet = getSensitiveWords();
            // 将敏感词库加入到HashMap中
            addSensitiveWordToHashMap(keyWordSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return initSensitiveWordMap;
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建模型(trim树）
     *
     * @param keyWords 敏感词集合
     */
    public void addSensitiveWordToHashMap(Set<String> keyWords) {
        // 初始化容器，减少扩容
        initSensitiveWordMap = new HashMap(keyWords.size());
        String key = null;
        Map nowMap = null;
        Map<String, String> newWordMap = null;
        // 迭代
        Iterator<String> iterator = keyWords.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            nowMap = initSensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);
                Object wordMap = nowMap.get(keyChar);

                if (null != wordMap) {
                    // 存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {
                    // 不存在，构建一个map，将结束为设置为0，因为不是最后一个
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWordMap);
                    nowMap = newWordMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }

    /**
     * 从数据库获取敏感词
     *
     * @return
     */
    public Set<String> getSensitiveWords() {
        Set<String> keyWords = new HashSet<>();
        List<String> sensitiveWords = adminDao.getSensitiveWords();
        for (String word : sensitiveWords) {
            keyWords.add(word);
        }
        return keyWords;
    }

    /**
     * 判断文字内容是否包含敏感字符
     *
     * @param content 文字内容
     * @return
     */
    public boolean isContainSensitiveWord(String content) {
        boolean flag = false;
        for (int i = 0; i < content.length(); i++) {
            int matchFlag = checkSensitiveWord(content, i);
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文字内容中的敏感词
     *
     * @param content 文字内容
     * @return
     */
    public Set<String> getSensitiveWord(String content) {
        Set<String> sensitiveWordsSet = new HashSet<>();
        for (int i = 0; i < content.length(); i++) {
            int length = checkSensitiveWord(content, i);
            if (length > 0) {
                sensitiveWordsSet.add(content.substring(i, i + length));
                i = i + length - 1;
            }
        }
        return sensitiveWordsSet;
    }

    /**
     * 检查文字中是否包含敏感字符
     *
     * @param content 文字内容
     * @param beginIndex
     * @return 如果存在敏感字符，返回敏感词字符长度，不存在返回0
     */
    public int checkSensitiveWord(String content, int beginIndex) {
        // 结束标志位
        boolean flag = true;
        int matchCount = 0;
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < content.length(); i++) {
            word = content.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (null != nowMap) {
                matchCount++;
                if ("1".equals(nowMap.get("isEnd"))) {
                    flag = true;
                }
            } else {
                // 不存在，直接返回
                break;
            }
        }

        if (matchCount < 2 || !flag) {
            matchCount = 0;
        }
        return matchCount;
    }


}
