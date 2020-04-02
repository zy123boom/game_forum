package com.boomzy.dao;

import com.boomzy.domain.GameSection;
import com.boomzy.domain.Opinion;
import com.boomzy.domain.User;
import com.boomzy.dao.AdminDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 20:14
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    public void loginTest() {
        String username = "itachi";
        String password = "zy123456";
        int login = adminDao.login(username, password);
        System.out.println(login);
    }

    @Test
    public void updateGameSectionNameTest() {
        String old = "LOL";
        String New = "英雄联盟";
        int result = adminDao.updateGameSectionName(old, New);
        System.out.println(result);
    }

    @Test
    public void queryGameSectionNameCountTest() {
        String name = "英雄联盟";
        System.out.println(adminDao.queryGameSectionNameCount(name));
    }

    @Test
    public void addGameSectionNameTest() {
        GameSection gameSection = new GameSection();
        gameSection.setGameSectionId("game1875");
        gameSection.setGameSectionName("QQ飞车");
        gameSection.setCreateTime(new Date());
        gameSection.setUpdateTime((new Date()));
        System.out.println(adminDao.addGameSectionName(gameSection));
    }

    @Test
    public void showUserOpinionTest() {
        List<Opinion> opinions = adminDao.showUserOpinion();
        for (Opinion opinion : opinions) {
            System.out.println(opinion);
        }
    }

    @Test
    public void showUsersTest() {
        List<User> users = adminDao.showUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
