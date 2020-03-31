package com.boomzy.dao;

import com.boomzy.domain.Comment;
import com.boomzy.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/3/4 17:16
 */
@Repository
public interface PostDao {
    /**
     * 根据游戏板块名展示讨论帖
     *
     * @param gameSectionName
     * @return
     */
    List<Post> showPost(String gameSectionName);

    /**
     * 根据帖子ID增加帖子浏览量
     *
     * @param postId
     */
    void addViewCount(String postId);

    /**
     * 根据帖子ID展示帖子内容
     *
     * @param postId
     */
    String showPostContent(String postId);

    /**
     * 根据帖子标题查询帖子ID
     *
     * @param postSubject
     * @return
     */
    String queryPostIdByPostSubject(String postSubject);

    /**
     * 根据帖子ID展示帖子评论
     *
     * @param postId
     * @return
     */
    List<Comment> showCommentInformation(String postId);

    /**
     * 新增帖子
     *
     * @param post
     * @return
     */
    int addPost(Post post);

    /**
     * 新增评论
     *
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 根据帖子内容查询帖子ID
     *
     * @param postContent
     * @return
     */
    String queryPostIdByPostContent(String postContent);

    /**
     * 根据帖子内容增加帖子访问量
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
     * 新增评论回复
     *
     * @param comment
     * @return
     */
    int addReply(Comment comment);

    /**
     * 根据commentId展示评论回复
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
