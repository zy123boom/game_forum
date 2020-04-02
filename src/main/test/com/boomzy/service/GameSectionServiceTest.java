package com.boomzy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 19:51
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class GameSectionServiceTest {

    @Autowired
    private GameSectionService gameSectionService;

    @Test
    public void showGameSectionTest() {
        List<String> gameSections = gameSectionService.showGameSection();
        for (String game : gameSections) {
            System.out.print(game + " ");
        }
    }
}
