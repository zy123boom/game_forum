package com.boomzy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author boomzy
 * @date 2020/4/3 10:24
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class SensitiveWordServiceTest {

    @Autowired
    private SensitiveWordService sensitiveWordService;

    @Test
    public void getSensitiveWordsTest() {
        Set<String> sensitiveWords = sensitiveWordService.getSensitiveWords();
        System.out.println(sensitiveWords.size());
    }

    @Test
    public void initKeyWordTest() {
        Map map = sensitiveWordService.initKeyWord();
        System.out.println(map.size());
    }

    @Test
    public void isContainSensitiveWordTest() {
        String content1 = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释" +
                "自杀指南怀那些自己经历的伤感。然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵" +
                "强的把自己的情感也附加于银幕情节中，然后感动就流泪，难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复" +
                "制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        String content2 = "RNG击败TES";
        String content3 = "我想强奸你";
        boolean result1 = sensitiveWordService.isContainSensitiveWord(content1);
        boolean result2 = sensitiveWordService.isContainSensitiveWord(content3);
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
    public void getSensitiveWordTest() {
        String content = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释" +
                "自杀指南怀那些自己经历的伤感。然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵" +
                "强的把自己的情感也附加于银幕情节中，然后感动就流泪，难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复" +
                "制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        Set<String> sensitiveWord = sensitiveWordService.getSensitiveWord(content);
        Iterator<String> iterator = sensitiveWord.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
