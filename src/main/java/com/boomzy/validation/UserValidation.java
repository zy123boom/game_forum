package com.boomzy.validation;

import com.boomzy.domain.User;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户登录/注册验证
 *
 * @author boomzy
 * @date 2020/2/27 10:32
 */
public class UserValidation {
    private static Logger logger = LoggerFactory.getLogger(UserValidation.class);

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @return <code>true</code> 验证通过; <code>false</code> 验证失败.
     */
    public static boolean loginValidation(String username, String password) {
        if (username == null || password == null || username.length() == 0 || password.length() == 0) {
            return false;
        }
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        }
        return true;
    }

    /**
     * 注册验证
     *
     * @param user
     * @param confirmPassword
     * @return <code>true</code> 验证通过; <code>false</code> 验证失败.
     */
    public static boolean registerValidation(User user, String confirmPassword) {
        if (null == user) {
            return false;
        }
        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getRealName()) ||
                StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getSex()) ||
                StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(confirmPassword)) {
            return false;
        }

        if (user.getPassword().length() < 6) {
            logger.info("密码长度小于6位");
            return false;
        }

        if (!user.getEmail().matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            logger.info("邮箱格式不正确");
            return false;
        }

        if (!user.getPassword().equals(confirmPassword)) {
            logger.info("两次输入密码不一致");
            return false;
        }

        if (user.getUserName().indexOf(" ") != -1) {
            return false;
        }

        if (user.getRealName().indexOf(" ") != -1) {
            return false;
        }

        if (user.getPassword().indexOf(" ") != -1) {
            return false;
        }

        if (user.getSex().indexOf(" ") != -1) {
            return false;
        }

        if (user.getEmail().indexOf(" ") != -1) {
            return false;
        }

        return true;
    }
}
