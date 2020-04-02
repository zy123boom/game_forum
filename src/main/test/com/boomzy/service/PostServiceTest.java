package com.boomzy.service;

import com.boomzy.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/2 20:09
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void showPostTest() {
        String game = "英雄联盟";
        List<Post> posts = postService.showPost(game);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void showHotPostTest() {
        String game = "英雄联盟";
        List<Post> posts = postService.showHotPost(game);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void showPostContentTest() {
        String postId = "post2580";
        String content = postService.showPostContent(postId);
        System.out.println(content);
    }
}
