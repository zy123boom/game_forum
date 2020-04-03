package com.boomzy.service.impl;

import com.boomzy.dao.AdminDao;
import com.boomzy.service.SensitiveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author boomzy
 * @date 2020/4/3 10:39
 */
@Service("sensitiveWordService")
public class SensitiveWordServiceImpl implements SensitiveWordService{

    @Autowired
    private AdminDao adminDao;


    @Override
    public Map initKeyWord() {
        Map initSensitiveWordMap = new HashMap<>();
        try {
            // 读取敏感词库
            Set<String> keyWordSet = getSensitiveWords();

            // 将敏感词库加入到HashMap中
            initSensitiveWordMap = addSensitiveWordToHashMap(keyWordSet);
            return initSensitiveWordMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return initSensitiveWordMap;
    }

    @Override
    public Map addSensitiveWordToHashMap(Set<String> keyWords) {
        // 初始化容器，减少扩容
        Map initSensitiveWordMap = new HashMap<>(keyWords.size());
        String key = null;
        Map nowMap = null;
        Map newWordMap = null;
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
        return initSensitiveWordMap;
    }

    @Override
    public Set<String> getSensitiveWords() {
        Set<String> keyWords = new HashSet<>();
        List<String> sensitiveWords = adminDao.getSensitiveWords();
        for (String word : sensitiveWords) {
            keyWords.add(word);
        }
        return keyWords;
    }

    @Override
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

    @Override
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

    @Override
    public int checkSensitiveWord(String content, int beginIndex) {
        // 结束标志位
        boolean flag = true;
        int matchCount = 0;
        char word = 0;
        Map nowMap = initKeyWord();
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
