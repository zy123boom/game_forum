package com.boomzy.validation;

import org.apache.commons.lang3.StringUtils;

/**
 * 游戏模块验证类
 *
 * @author boomzy
 * @date 2020/3/19 11:29
 */
public class GameSectionValidation {
    public static boolean updateGameSectionNameValidate(String oldGameSectionName, String newGameSectionName) {
        if (oldGameSectionName == null || newGameSectionName == null) {
            return false;
        }
        if (oldGameSectionName.equals(newGameSectionName)) {
            return false;
        }
        if (StringUtils.isBlank(newGameSectionName)) {
            return false;
        }
        return true;
    }
}
