package com.boomzy.controller;

import com.boomzy.domain.*;
import com.boomzy.enums.LoginEnum;
import com.boomzy.service.AdminService;
import com.boomzy.service.PostService;
import com.boomzy.service.SensitiveWordService;
import com.boomzy.util.RandomUtils;
import com.boomzy.validation.GameSectionValidation;
import com.boomzy.validation.OpinionValidation;
import com.boomzy.validation.UserValidation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 管理员控制器
 *
 * @author boomzy
 * @date 2020/3/18 10:41
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private GameSectionController gameSectionController;

    @Autowired
    private PostService postService;

    @Autowired
    private SensitiveWordService sensitiveWordService;

    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @param request
     * @param response
     */
    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-admin login start");
        HttpSession session = request.getSession();
        if (!UserValidation.loginValidation(username, password)) {
            logger.info("controller-admin login failed, parameter valid is illegal");
            response.sendRedirect("login_error.jsp");
            logger.info("controller-admin login end");
            return;
        }
        int result = adminService.login(username, password);
        if (result == LoginEnum.SUCCESS.getCode()) {
            logger.info("controller-admin login success!");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            // 登陆成功同时展示游戏模块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/admin/forum_home.jsp").forward(request, response);
        } else if (result == LoginEnum.LOGIN_FAIL.getCode()) {
            logger.info("controller-admin login failed, username or password is wrong");
            response.sendRedirect("login_fail.jsp");
        } else {
            logger.info("controller-admin login failed, system error");
            throw new RuntimeException("System error");
        }
        logger.info("controller-admin login end");
    }

    /**
     * 根据游戏模块名更新游戏模块名称
     *
     * @param oldGameSectionName 修改前的游戏模块名
     * @param newGameSectionName 修改后的游戏模块名
     * @param request
     * @param response
     */
    @RequestMapping("/updateGameSectionName")
    public void updateGameSectionName(String oldGameSectionName, String newGameSectionName, HttpServletRequest request,
                                      HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-updateGameSectionName start");
        if (!GameSectionValidation.updateGameSectionNameValidate(oldGameSectionName, newGameSectionName)) {
            logger.info("controller-updateGameSectionName failed, parameter valid is illegal");
            response.sendRedirect("update_game_section_name_fail.jsp");
            logger.info("controller-updateGameSectionName end");
            return;
        }
        int result = adminService.updateGameSectionName(oldGameSectionName, newGameSectionName);
        if (result == 1) {
            logger.info("controller-updateGameSectionName success");
            // 再查一次游戏板块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/admin/forum_home.jsp").forward(request, response);
        } else {
            logger.info("controller-updateGameSectionName failed");
            response.sendRedirect("update_game_section_name_fail.jsp");
        }
        logger.info("controller-updateGameSectionName end");
    }

    /**
     * 删除游戏模块
     *
     * @param gameSectionName
     * @param request
     * @param response
     */
    @RequestMapping("/deleteGameSectionName")
    public void deleteGameSectionName(String gameSectionName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("controller-deleteGameSectionName start");
        int result = adminService.deleteGameSectionName(gameSectionName);
        if (result == 1) {
            logger.info("controller-deleteGameSectionName success");
            // 再查一次游戏板块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/admin/forum_home.jsp").forward(request, response);
        } else {
            logger.info("controller-deleteGameSectionName failed");
            response.sendRedirect("update_game_section_name_fail.jsp");
        }
        logger.info("controller-deleteGameSectionName end");
    }

    /**
     * 新增游戏板块
     *
     * @param gameSectionName
     * @param request
     * @param response
     */
    @RequestMapping("/addGameSectionName")
    public void addGameSectionName(String gameSectionName, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-addGameSectionName start");
        if (gameSectionName == null || StringUtils.isBlank(gameSectionName)) {
            logger.info("controller-addGameSectionName failed, parameter valid is illegal");
            response.sendRedirect("update_game_section_name_fail.jsp");
            logger.info("controller-addGameSectionName end");
            return;
        }
        // 查要新增的游戏模块是否存在
        int count = adminService.queryGameSectionNameCount(gameSectionName);
        if (count >= 1) {
            logger.info("controller-addGameSectionName，this gameSection is already exist");
            response.sendRedirect("update_game_section_name_fail.jsp");
            logger.info("controller-addGameSectionName end");
            return;
        }
        GameSection gameSection = new GameSection();
        gameSection.setGameSectionId(RandomUtils.generationRandom("game"));
        gameSection.setGameSectionName(gameSectionName);
        gameSection.setCreateTime(new Date());
        gameSection.setUpdateTime(new Date());
        int result = adminService.addGameSectionName(gameSection);
        if (result == 1) {
            logger.info("controller-addGameSectionName success");
            // 再查询一次游戏板块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/admin/forum_home.jsp").forward(request, response);
        }
        logger.info("controller-addGameSectionName end");
    }

    /**
     * 展示游戏板块里的讨论帖（管理员）
     *
     * @param gameSectionName
     * @param request
     * @param response
     */
    @RequestMapping("/showPost")
    public void showPost(String gameSectionName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-showPost start");
        HttpSession session = request.getSession();
        List<Post> posts = postService.showPost(gameSectionName);
        if (null != posts) {
            // 查敏
            for (Post post : posts) {
                if (sensitiveWordService.isContainSensitiveWord(post.getPostContent())) {
                    // 敏感帖子，置为敏感性
                    adminService.updateSensitivityByPostId(post.getPostId());
                }
            }
            logger.info("controller-showPost success");
            request.setAttribute("posts", posts);
            session.setAttribute("gameSectionName", gameSectionName);
            request.getRequestDispatcher("/admin/forum_post.jsp").forward(request, response);
        }
        logger.info("controller-showPost end");
    }

    /**
     * 根据帖子ID展示帖子内容（管理员）
     *
     * @param postId
     * @param request
     * @param response
     */
    @RequestMapping("/showPostContent")
    public void showPostContent(String postId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-showPostContent start");
        String postContent = postService.showPostContent(postId);
        request.setAttribute("postContent", postContent);
        // 查询帖子评论信息，一并展示在post_content.jsp
        // 根据postId查评论信息
        List<Comment> comments = postService.showCommentInformation(postId);
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/admin/post_content.jsp").forward(request, response);
        logger.info("controller-showPostContent end");
    }

    /**
     * 根据postId删除帖子
     *
     * @param postId
     * @param request
     * @param response
     */
    @RequestMapping("/deletePostByPostId")
    public void deletePostByPostId(String postId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-deletePostByPostId start");
        HttpSession session = request.getSession();
        // 删除讨论帖（逻辑删除）
        int result = adminService.deletePostByPostId(postId);
        if (result == 1) {
            // 删除该讨论帖对应的所有评论
            adminService.deleteCommentByPostId(postId);
            logger.info("controller-deletePostByPostId success");
            String gameSectionName = (String)session.getAttribute("gameSectionName");
            // 再次展示该游戏板块的所有讨论帖
            showPost(gameSectionName, request, response);
        }
        logger.info("controller-deletePostByPostId end");
    }

    /**
     * 根据commentId删除评论
     *
     * @param commentId
     * @param postId
     * @param request
     * @param response
     */
    @RequestMapping("/deleteCommentByCommentId")
    public void deleteCommentByCommentId(String commentId, String postId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-deleteCommentByCommentId start");
        if (null != commentId) {
            int result = adminService.deleteCommentByCommentId(commentId);
            if (result == 1) {
                // 删除帖子成功，减少帖子评论量
                adminService.reduceCommentCount(postId);
                // 删除所有该评论的回复
                adminService.deleteReplyByCommentReplyId(commentId);
                logger.info("controller-deleteCommentByCommentId success");
                // 展示页面
                showPostContent(postId, request, response);
            } else {
                logger.info("controller-deleteCommentByCommentId failed");
            }
        }
        logger.info("controller-deleteCommentByCommentId end");
    }

    /**
     * 展示用户意见
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/showUserOpinion")
    public void showUserOpinion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-showUserOpinion start");
        HttpSession session = request.getSession();
        List<Opinion> opinions = adminService.showUserOpinion();
        if (null != opinions) {
            session.setAttribute("opinions", opinions);
            request.getRequestDispatcher("/admin/user_opinion.jsp").forward(request, response);
            logger.info("controller-showUserOpinion success");
        }
        logger.info("controller-showUserOpinion end");
    }

    /**
     * 回复用户意见
     *
     * @param opinionId
     * @param opinionReply
     * @param request
     * @param response
     */
    @RequestMapping("/addOpinionReply")
    public void addOpinionReply(String opinionId, String opinionReply, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-addOpinionReply start");
        if (!OpinionValidation.addOpinionValidation(opinionReply)) {
            logger.info("controller-addOpinionReply failed, parameter valid illegal!");
            response.sendRedirect("opinion_reply_fail.jsp");
            logger.info("controller-addOpinionReply end");
            return;
        }
        int result = adminService.addOpinionReply(opinionId, opinionReply);
        if (result == 1) {
            logger.info("controller-addOpinionReply success");
            // 返回意见界面，即再次展示用户意见
            showUserOpinion(request, response);
        } else {
            logger.info("controller-addOpinionReply failed");
            response.sendRedirect("opinion_reply_fail.jsp");
        }
        logger.info("controller-addOpinionReply end");
    }

    /**
     * 展示用户（用户管理）
     *
     * @param request
     * @param response
     */
    @RequestMapping("/showUsers")
    public void showUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-showUsers start");
        List<User> users = adminService.showUsers();
        if (null != users) {
            logger.info("controller-showUsers success");
            request.setAttribute("users", users);
            request.getRequestDispatcher("/admin/user_information.jsp").forward(request, response);
        } else {
            logger.info("controller-showUsers failed");
            response.sendRedirect("show_information_fail.jsp");
        }
        logger.info("controller-showUsers end");
    }

    /**
     * 删除用户
     *
     * @param username
     * @param request
     * @param response
     */
    @RequestMapping("/deleteUser")
    public void deleteUser(String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-deleteUser start");
        int result = adminService.deleteUser(username);
        if (result == 1) {
            logger.info("controller-deleteUser success");
            // 删除成功后，重新查询用户
            showUsers(request, response);
        } else {
            logger.info("controller-deleteUser failed");
            logger.info("controller-deleteUser end");
            throw new RuntimeException("deleteUser error");
        }
        logger.info("controller-deleteUser end");
    }
}
