package com.boomzy.dao;

import com.boomzy.domain.Post;
import com.boomzy.dao.PostDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 20:19
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void showPostTest() {
        String game = "英雄联盟";
        List<Post> posts = postDao.showPost(game);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void showHotPostTest() {
        String game = "英雄联盟";
        List<Post> posts = postDao.showHotPost(game);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void showPostContentTest() {
        String postId = "post2580";
        String content = postDao.showPostContent(postId);
        System.out.println(content);
    }
}
