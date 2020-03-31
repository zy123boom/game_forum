package com.boomzy.dao;

import com.boomzy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/2/24 17:56
 */
@Repository
public interface UserDao {

    /**
     * 判断该用户是否在小黑屋中
     *
     * @param username 用户名
     * @return
     */
    int findInDarkHouse(String username);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    int login(@Param("username") String username,@Param("password") String password);

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
