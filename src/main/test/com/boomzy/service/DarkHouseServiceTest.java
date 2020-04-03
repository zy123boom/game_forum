package com.boomzy.service;

import com.boomzy.service.DarkHouseService;
import com.boomzy.domain.DarkUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/3 21:10
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class DarkHouseServiceTest {
    @Autowired
    private DarkHouseService darkHouseService;

    @Test
    public void showDarkUserTest() {
        List<DarkUser> darkUsers = darkHouseService.showDarkUser();
        for (DarkUser darkUser : darkUsers) {
            System.out.println(darkUser);
        }
    }

    @Test
    public void deleteFromDarkHomeTest() {
        String darkName = "uzi2";
        int res = darkHouseService.deleteFromDarkHome(darkName);
        System.out.println(res);
    }
}
