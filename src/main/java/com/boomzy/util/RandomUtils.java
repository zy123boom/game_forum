package com.boomzy.util;

/**
 * 随机数产生工具类
 *
 * @author boomzy
 * @date 2020/3/16 10:55
 */
public class RandomUtils {

    /**
     * ID生成
     *
     * @param source
     * @return
     */
    public static String generationRandom(String source) {
        StringBuffer sb = new StringBuffer();
        sb.append(source);
        sb.append((int)(Math.random() * 10000));
        return sb.toString();
    }
}
