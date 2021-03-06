package com.boomzy.service;

import com.boomzy.dao.UserDao;
import com.boomzy.domain.User;
import com.boomzy.enums.UserTypeEnum;
import com.boomzy.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author boomzy
 * @date 2020/3/2 17:28
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void loginTest() {
        String username = "boomzy";
        String password = "zy123456";
        int login = userService.login(username, password);
        System.out.println(login);
    }

    @Test
    public void registerTest() {
        User user = new User();
        user.setUserName("uzi");
        user.setRealName("简自豪");
        user.setPassword("jzh123456");
        user.setSex("男");
        user.setEmail("100000001@qq.com");
        user.setUserType(UserTypeEnum.NORMAL_USER.getCode());
        user.setProvince("湖北");
        user.setCity("宜昌");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int res = userService.register(user);
        System.out.println(res);
    }

    @Test
    public void showUserInformationTest() {
        String username = "uzi";
        User user = userService.showUserInformation(username);
        System.out.println(user);
    }
}
