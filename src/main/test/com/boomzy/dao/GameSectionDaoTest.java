package com.boomzy.dao;

import com.boomzy.dao.GameSectionDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 20:17
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class GameSectionDaoTest {
    @Autowired
    private GameSectionDao gameSectionDao;

    @Test
    public void showGameSectionTest() {
        List<String> gameSections = gameSectionDao.showGameSection();
        for (String game : gameSections) {
            System.out.print(game + " ");
        }
    }
}
