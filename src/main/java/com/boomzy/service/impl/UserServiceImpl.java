package com.boomzy.service.impl;

import com.boomzy.dao.UserDao;
import com.boomzy.domain.User;
import com.boomzy.enums.LoginEnum;
import com.boomzy.enums.UserTypeEnum;
import com.boomzy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author boomzy
 * @date 2020/2/24 17:59
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public int login(String username, String password) {
        logger.info("service层登陆功能开始");
        // 查询用户名是否在小黑屋里
        int inDarkHouse = userDao.findInDarkHouse(username);
        if (inDarkHouse == 1) {
            logger.info("service-用户已被封号");
            return LoginEnum.USER_IN_DARK.getCode();
        }
        // 用户登录
        int loginResult = userDao.login(username, password);
        if (loginResult == 1) {
            logger.info("service-用户登录成功");
            return LoginEnum.SUCCESS.getCode();
        }
        if (loginResult == 0) {
            logger.info("service-登陆失败，用户名或密码错误");
            return LoginEnum.LOGIN_FAIL.getCode();
        }
        logger.info("service-登陆功能结束");
        return LoginEnum.SYSTEM_ERROR.getCode();
    }

    @Override
    public int register(User user) {
        logger.info("service层注册功能开始");
        logger.info("service-注册功能结束");
        return userDao.register(user);
    }

    @Override
    public int queryUserNameCount(String userName) {
        logger.info("service-查询用户名数目功能开始");
        int result = userDao.queryUserNameCount(userName);
        if (result >= 1) {
            logger.info("service-查询用户名数目-用户名重复");
        }
        logger.info("service-查询用户名数目功能结束");
        return result;
    }

    @Override
    public User showUserInformation(String username) {
        logger.info("service-展示用户信息功能开始");
        User user = userDao.showUserInformation(username);
        if (null != user) {
            logger.info("service-展示用户信息成功");
        } else {
            logger.info("service-展示用户信息失败");
        }
        logger.info("service-展示用户信息功能结束");
        return user;
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        logger.info("service-修改密码功能开始");
        int result = userDao.updatePassword(username, oldPassword, newPassword);
        if (result == LoginEnum.SUCCESS.getCode()) {
            logger.info("service-修改密码成功");
        } else {
            logger.info("service-修改密码失败");
        }
        logger.info("service-修改密码功能结束");
        return result;
    }
}
