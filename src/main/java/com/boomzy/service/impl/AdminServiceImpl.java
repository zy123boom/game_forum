package com.boomzy.service.impl;

import com.boomzy.dao.AdminDao;
import com.boomzy.domain.GameSection;
import com.boomzy.domain.Opinion;
import com.boomzy.domain.User;
import com.boomzy.enums.LoginEnum;
import com.boomzy.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/3/18 10:52
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private AdminDao adminDao;

    @Override
    public int login(String username, String password) {
        logger.info("service-admin login start");
        int result = adminDao.login(username, password);
        if (result == LoginEnum.SUCCESS.getCode()) {
            logger.info("service-admin login success");
        } else if (result == LoginEnum.LOGIN_FAIL.getCode()) {
            logger.info("service-admin login failed, username or password is wrong");
        } else if (result == LoginEnum.SYSTEM_ERROR.getCode()){
            logger.info("service-admin login failed, system error");
        }
        logger.info("service-admin login end");
        return result;
    }

    @Override
    public int updateGameSectionName(String oldGameSectionName, String newGameSectionName) {
        logger.info("service-updateGameSectionName start");
        int result = adminDao.updateGameSectionName(oldGameSectionName, newGameSectionName);
        if (result == 1) {
            logger.info("service-updateGameSectionName success");
            // 修改帖子表里板块名的也变成新的名字
            adminDao.updateGameSectionNameInPostInformation(oldGameSectionName, newGameSectionName);
        } else {
            logger.info("service-updateGameSectionName failed");
        }
        logger.info("service-updateGameSectionName end");
        return result;
    }

    @Override
    public int deleteGameSectionName(String gameSectionName) {
        logger.info("service-deleteGameSectionName start");
        int result = adminDao.deleteGameSectionName(gameSectionName);
        if (result == 1) {
            logger.info("service-deleteGameSectionName success");
            // 删除该模块下对应的所有帖子(逻辑删除)
            adminDao.deleteAllPostByGameSectionName(gameSectionName);
        } else {
            logger.info("service-deleteGameSectionName failed");
        }
        logger.info("service-deleteGameSectionName end");
        return result;
    }

    @Override
    public int queryGameSectionNameCount(String gameSectionName) {
        return adminDao.queryGameSectionNameCount(gameSectionName);
    }

    @Override
    public int addGameSectionName(GameSection gameSection) {
        logger.info("service-addGameSectionName start");
        int result = adminDao.addGameSectionName(gameSection);
        if (result == 1) {
            logger.info("service-addGameSectionName success");
        } else {
            logger.info("service-addGameSectionName failed");
        }
        logger.info("service-addGameSectionName end");
        return result;
    }

    @Override
    public int deletePostByPostId(String postId) {
        logger.info("service-deletePostByPostId start");
        int result = adminDao.deletePostByPostId(postId);
        if (result == 1) {
            logger.info("service-deletePostByPostId success");
        } else {
            logger.info("service-deletePostByPostId failed");
        }
        logger.info("service-deletePostByPostId end");
        return result;
    }

    @Override
    public void deleteCommentByPostId(String postId) {
        adminDao.deleteCommentByPostId(postId);
    }

    @Override
    public int deleteCommentByCommentId(String commentId) {
        logger.info("service-deleteCommentByCommentId start");
        int result = adminDao.deleteCommentByCommentId(commentId);
        if (result == 1) {
            logger.info("service-deleteCommentByCommentId success");
        } else {
            logger.info("service-deleteCommentByCommentId failed");
        }
        logger.info("service-deleteCommentByCommentId end");
        return result;
    }

    @Override
    public void reduceCommentCount(String postId) {
        adminDao.reduceCommentCount(postId);
    }

    @Override
    public void deleteReplyByCommentReplyId(String commentId) {
        adminDao.deleteReplyByCommentReplyId(commentId);
    }

    @Override
    public List<Opinion> showUserOpinion() {
        logger.info("service-showUserOpinion start");
        List<Opinion> opinions = adminDao.showUserOpinion();
        if (null != opinions) {
            logger.info("service-showUserOpinion success");
        } else {
            logger.info("service-showUserOpinion failed");
        }
        logger.info("service-showUserOpinion end");
        return opinions;
    }

    @Override
    public int addOpinionReply(String opinionId, String opinionReply) {
        logger.info("service-addOpinionReply start");
        int result = adminDao.addOpinionReply(opinionId, opinionReply);
        if (result == 1) {
            logger.info("service-addOpinionReply success");
        } else {
            logger.info("service-addOpinionReply failed");
        }
        logger.info("service-addOpinionReply end");
        return result;
    }

    @Override
    public List<User> showUsers() {
        logger.info("service-showUsers start");
        List<User> users = adminDao.showUsers();
        if (null != users) {
            logger.info("service-showUsers success");
        } else {
            logger.info("service-showUsers failed");
        }
        logger.info("service-showUsers end");
        return users;
    }

    @Override
    public int deleteUser(String username) {
        logger.info("service-deleteUser start");
        int result = adminDao.deleteUser(username);
        if (result == 1) {
            logger.info("service-deleteUser success");
        } else {
            logger.info("service-deleteUser failed");
        }
        logger.info("service-deleteUser end");
        return result;

    }

    @Override
    public int checkSensitiveWord(String postContent) {
        return 0;
    }
}
