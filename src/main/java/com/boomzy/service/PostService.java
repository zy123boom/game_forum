package com.boomzy.service;

import com.boomzy.domain.Comment;
import com.boomzy.domain.Post;

import java.util.List;

/**
 * 帖子服务
 *
 * @author boomzy
 * @date 2020/3/4 16:38
 */
public interface PostService {

    /**
     * 根据游戏板块名展示讨论帖
     *
     * @param gameSectionName
     * @return
     */
    List<Post> showPost(String gameSectionName);

    /**
     * 根据游戏板块名展示热帖
     *
     * @param gameSectionName
     * @return
     */
    List<Post> showHotPost(String gameSectionName);

    /**
     * 根据帖子ID展示帖子内容
     *
     * @param postId
     */
    String showPostContent(String postId);

    /**
     * 根据帖子ID增加帖子浏览量
     *
     * @param postId
     */
    void addViewCount(String postId);

    /**
     * 根据帖子标题查询帖子ID
     * 
     * @param postSubject
     */
    String queryPostIdByPostSubject(String postSubject);

    /**
     * 根据帖子ID展示评论信息
     *
     * @param postId
     * @return
     */
    List<Comment> showCommentInformation(String postId);

    /**
     * 增加新帖
     *
     * @param post
     */
    int addPost(Post post);

    /**
     * 根据帖子内容查询帖子ID
     *
     * @param postContent
     */
    String queryPostIdByPostContent(String postContent);

    /**
     * 增加新评论
     *
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 根据帖子内容增加帖子浏览量
     *
     * @param postContent
     */
    void addCommentCount(String postContent);

    /**
     * 根据commentId查询postId
     *
     * @param commentId
     * @return
     */
    String queryPostIdByCommentId(String commentId);

    /**
     * 新增回复评论
     *
     * @param comment
     * @return
     */
    int addReply(Comment comment);

    /**
     * 根据commentId展示回复信息
     *
     * @param commentId
     * @return
     */
    List<Comment> showReplies(String commentId);

    /**
     * 根据postId增加评论数量
     *
     * @param postId
     */
    void addCommentCountByPostId(String postId);
}
