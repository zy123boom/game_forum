package com.boomzy.service;

import com.boomzy.domain.GameSection;
import com.boomzy.domain.Opinion;

import java.util.List;

/**
 * 管理员服务
 *
 * @author boomzy
 * @date 2020/3/18 10:51
 */
public interface AdminService {
    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @return
     */
    int login(String username, String password);

    /**
     * 修改游戏模块名
     *
     * @param oldGameSectionName
     * @param newGameSectionName
     * @return
     */
    int updateGameSectionName(String oldGameSectionName, String newGameSectionName);

    /**
     * 删除游戏模块名
     *
     * @param gameSectionName
     * @return
     */
    int deleteGameSectionName(String gameSectionName);

    /**
     * 查询该游戏板块是否存在
     *
     * @param gameSectionName
     * @return
     */
    int queryGameSectionNameCount(String gameSectionName);

    /**
     * 新增游戏板块
     *
     * @param gameSection
     * @return
     */
    int addGameSectionName(GameSection gameSection);

    /**
     * 根据postId删除帖子（逻辑删除）
     *
     * @param postId
     * @return
     */
    int deletePostByPostId(String postId);

    /**
     * 根据postId删除评论
     *
     * @param postId
     */
    void deleteCommentByPostId(String postId);

    /**
     * 根据commentId删除评论
     *
     * @param commentId
     * @return
     */
    int deleteCommentByCommentId(String commentId);

    /**
     * 减少帖子评论量
     *
     * @param postId
     */
    void reduceCommentCount(String postId);

    /**
     * 根据commentId删除回复
     *
     * @param commentId
     */
    void deleteReplyByCommentReplyId(String commentId);

    /**
     * 查看用户提出的意见
     *
     * @return
     */
    List<Opinion> showUserOpinion();

    /**
     * 回复用户意见
     *
     * @param opinionId
     * @param opinionReply
     * @return
     */
    int addOpinionReply(String opinionId, String opinionReply);
}
