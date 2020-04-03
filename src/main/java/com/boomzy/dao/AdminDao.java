package com.boomzy.dao;

import com.boomzy.domain.GameSection;
import com.boomzy.domain.Opinion;
import com.boomzy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员持久层
 *
 * @author boomzy
 * @date 2020/3/18 11:01
 */
@Repository
public interface AdminDao {
    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @return
     */
    int login(@Param("username") String username, @Param("password") String password);

    int updateGameSectionName(@Param("oldGameSectionName") String oldGameSectionName, @Param("newGameSectionName") String newGameSectionName);

    /**
     * 修改帖子信息表的游戏板块名为新版块
     *
     * @param oldGameSectionName
     * @param newGameSectionName
     * @return
     */
    void updateGameSectionNameInPostInformation(@Param("oldGameSectionName") String oldGameSectionName, @Param("newGameSectionName") String newGameSectionName);

    /**
     * 删除游戏板块
     *
     * @param gameSectionName
     * @return
     */
    int deleteGameSectionName(String gameSectionName);

    /**
     * 删除该游戏板块下的所有帖子
     *
     * @param gameSectionName
     */
    void deleteAllPostByGameSectionName(String gameSectionName);

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
     * 根据postId删除讨论帖（逻辑删除）
     *
     * @param postId
     * @return
     */
    int deletePostByPostId(String postId);

    /**
     * 根据postId删除帖子评论
     *
     * @param postId
     */
    void deleteCommentByPostId(String postId);

    /**
     * 根据commentId删除帖子评论
     *
     * @param commentId
     * @return
     */
    int deleteCommentByCommentId(String commentId);

    /**
     * 减小帖子评论量
     *
     * @param postId
     */
    void reduceCommentCount(String postId);

    /**
     * 删除评论后，根据commentReplyId删除回复
     *
     * @param commentId
     */
    void deleteReplyByCommentReplyId(String commentId);

    /**
     * 展示用户意见
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
    int addOpinionReply(@Param("opinionId") String opinionId, @Param("opinionReply") String opinionReply);

    /**
     * 展示用户
     *
     * @return
     */
    List<User> showUsers();

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    int deleteUser(String username);

    List<String> getSensitiveWords();
}
