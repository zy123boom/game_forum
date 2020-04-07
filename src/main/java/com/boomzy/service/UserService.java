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

    /**
     * 修改密码
     *
     * @param username
     * @param newPassword
     * @return
     */
    int updatePassword(String username, String oldPassword, String newPassword);

    /**
     * 根据username修改密码
     *
     * @param username
     * @param newPassword
     * @return
     */
    int updatePasswordByUsername(String username, String newPassword);

    /**
     * 查询用户
     *
     * @param username
     * @return
     */
    int queryUserByUserName(String username);
}
