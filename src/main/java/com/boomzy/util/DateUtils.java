package com.boomzy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 有关Date的工具类
 *
 * @author boomzy
 * @date 2020/3/8 14:56
 */
public class DateUtils {

    /**
     * 将Date转换成 yyyy-MM-dd HH:mm:ss 的格式
     *
     * @param date
     * @return
     */
    public static String conversionDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }
}
