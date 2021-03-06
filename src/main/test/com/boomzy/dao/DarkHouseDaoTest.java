package com.boomzy.dao;

import com.boomzy.domain.DarkUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/3 21:00
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class DarkHouseDaoTest {

    @Autowired
    private DarkHouseDao darkHouseDao;

    @Test
    public void showDarkUserTest() {
        List<DarkUser> darkUsers = darkHouseDao.showDarkUser();
        for (DarkUser darkUser : darkUsers) {
            System.out.println(darkUser);
        }
    }

    @Test
    public void deleteFromDarkHomeTest() {
        String darkName = "uzi2";
        int res = darkHouseDao.deleteFromDarkHome(darkName);
        System.out.println(res);
    }
}
