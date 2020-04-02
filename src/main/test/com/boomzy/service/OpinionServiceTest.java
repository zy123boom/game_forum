package com.boomzy.service;

import com.boomzy.domain.Opinion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author boomzy
 * @date 2020/4/2 19:53
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class OpinionServiceTest {

    @Autowired
    private OpinionService opinionService;

    @Test
    public void addOpinionTest() {
        Opinion opinion = new Opinion();
        opinion.setOpinionId("op1001");
        opinion.setOpinionAuthor("uzi");
        opinion.setOpinionContent("希望论坛越来越好");
        opinion.setCreateTime(new Date());
        opinion.setUpdateTime(new Date());
        int res = opinionService.addOpinion(opinion);
        System.out.println(res);
    }
}
