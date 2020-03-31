package com.boomzy.service;

import com.boomzy.domain.User;


/**
 * 用户服务
 *
 * @author boomzy
 * @date 2020/2/24 17:58
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    int login(String username, String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 查询用户名数目（注册防重）
     *
     * @param userName
     * @return
     */
    int queryUserNameCount(String userName);

    /**
     * 展示用户信息
     *
     * @param username
     * @return
     */
    User showUserInformation(String username);
}
