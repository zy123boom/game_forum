package com.boomzy.service;

import com.boomzy.domain.GameSection;
import com.boomzy.domain.Opinion;
import com.boomzy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 19:58
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void loginTest() {
        String username = "itachi";
        String password = "zy123456";
        int login = adminService.login(username, password);
        System.out.println(login);
    }

    @Test
    public void updateGameSectionNameTest() {
        String old = "LOL";
        String New = "英雄联盟";
        int result = adminService.updateGameSectionName(old, New);
        System.out.println(result);
    }

    @Test
    public void queryGameSectionNameCountTest() {
        String name = "英雄联盟";
        System.out.println(adminService.queryGameSectionNameCount(name));
    }

    @Test
    public void addGameSectionNameTest() {
        GameSection gameSection = new GameSection();
        gameSection.setGameSectionId("game1875");
        gameSection.setGameSectionName("QQ飞车");
        gameSection.setCreateTime(new Date());
        gameSection.setUpdateTime((new Date()));
        System.out.println(adminService.addGameSectionName(gameSection));
    }

    @Test
    public void showUserOpinionTest() {
        List<Opinion> opinions = adminService.showUserOpinion();
        for (Opinion opinion : opinions) {
            System.out.println(opinion);
        }
    }

    @Test
    public void showUsersTest() {
        List<User> users = adminService.showUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
