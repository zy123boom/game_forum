package com.boomzy.validation;

import org.apache.commons.lang3.StringUtils;

/**
 * @author boomzy
 * @date 2020/3/13 11:14
 */
public class OpinionValidation {
    public static boolean addOpinionValidation(String opinion) {
        if (opinion == null) {
            return false;
        }
        if (StringUtils.isBlank(opinion)) {
            return false;
        }
        return true;
    }
}
