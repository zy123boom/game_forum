package com.boomzy.service.impl;

import com.boomzy.dao.PostDao;
import com.boomzy.domain.Comment;
import com.boomzy.domain.Post;
import com.boomzy.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/3/4 17:03
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    private static Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> showPost(String gameSectionName) {
        logger.info("service-展示讨论帖功能开始");
        logger.info("service-展示讨论帖功能结束");
        return postDao.showPost(gameSectionName);
    }

    @Override
    public String showPostContent(String postId) {
        logger.info("service-展示讨论帖内容功能开始");
        logger.info("service-展示讨论帖内容功能结束");
        return postDao.showPostContent(postId);
    }

    @Override
    public void addViewCount(String postId) {
        logger.info("service-增加帖子浏览量功能开始");
        postDao.addViewCount(postId);
        logger.info("service-增加帖子浏览量功能结束");
    }

    @Override
    public String queryPostIdByPostSubject(String postSubject) {
        return postDao.queryPostIdByPostSubject(postSubject);
    }

    @Override
    public List<Comment> showCommentInformation(String postId) {
        return postDao.showCommentInformation(postId);
    }

    @Override
    public int addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public String queryPostIdByPostContent(String postContent) {
        return postDao.queryPostIdByPostContent(postContent);
    }

    @Override
    public int addComment(Comment comment) {
        logger.info("service-新增评论功能开始");
        int result = postDao.addComment(comment);
        logger.info("service-新增评论功能结束");
        return result;
    }

    @Override
    public void addCommentCount(String postContent) {
        logger.info("service-增加帖子浏览量功能开始");
        postDao.addCommentCount(postContent);
        logger.info("service-增加帖子浏览量功能结束");
    }

    @Override
    public String queryPostIdByCommentId(String commentId) {
        return postDao.queryPostIdByCommentId(commentId);
    }

    @Override
    public int addReply(Comment comment) {
        logger.info("service-增加评论回复功能开始");
        int result = postDao.addReply(comment);
        logger.info("service-增加评论回复功能结束", result);
        return result;
    }

    @Override
    public List<Comment> showReplies(String commentId) {
        logger.info("service-展示评论回复信息功能开始");
        List<Comment> replies = postDao.showReplies(commentId);
        if (null != replies) {
            logger.info("service-展示评论回复信息成功", replies);
        }
        logger.info("service-展示评论回复信息功能结束");
        return replies;
    }

    @Override
    public void addCommentCountByPostId(String postId) {
        logger.info("service-根据postId增加评论数量功能开始");
        postDao.addCommentCountByPostId(postId);
        logger.info("service-根据postId增加评论数量功能结束");
    }
}
