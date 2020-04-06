package com.boomzy.controller;

import com.boomzy.domain.Comment;
import com.boomzy.domain.Post;
import com.boomzy.enums.PostEnum;
import com.boomzy.service.PostService;
import com.boomzy.util.RandomUtils;
import com.boomzy.validation.PostValidation;
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
 * 讨论帖控制器层
 *
 * @author boomzy
 * @date 2020/3/4 16:06
 */
@Controller
@RequestMapping("/post")
public class PostController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    /**
     * 展示游戏板块里对应的讨论帖
     *
     * @param request
     * @param response
     */
    @RequestMapping("/showPost")
    public void showPost(String gameSectionName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-展示讨论帖功能开始");
        List<Post> posts = postService.showPost(gameSectionName);
        HttpSession session = request.getSession();
        session.setAttribute("posts", posts);
        session.setAttribute("gameSectionName", gameSectionName);
        // 同时展示热帖
        showHotPost(gameSectionName, request, response);
        request.getRequestDispatcher("/user/post/forum_post.jsp").forward(request, response);
        logger.info("controller-展示讨论帖功能结束");
    }

    /**
     * 展示热帖
     *
     * @param gameSectionName
     * @param request
     * @param response
     */
    @RequestMapping("/showHotPost")
    public void showHotPost(String gameSectionName, HttpServletRequest request, HttpServletResponse response) {
        logger.info("controller-展示热帖功能开始");
        HttpSession session = request.getSession();
        // 热帖为浏览量大于60且评论量大于5
        List<Post> hotPosts = postService.showHotPost(gameSectionName);
        if (null != hotPosts) {
            logger.info("controller-展示热帖成功");
            session.setAttribute("hotPosts", hotPosts);
        } else {
            logger.info("controller-展示热帖失败");
        }
        logger.info("controller-展示热帖功能结束");
    }

    /**
     * 根据帖子标题展示帖子内容
     *
     * @param postId 帖子标题
     * @param request
     * @param response
     */
    @RequestMapping("/showPostContent")
    public void showPostContent(String postId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-展示讨论帖内容功能开始");
        HttpSession session = request.getSession();
        // 查询帖子内容
        String postContent = postService.showPostContent(postId);
        session.setAttribute("postContent", postContent);
        // 页面被访问，增加访问次数
        postService.addViewCount(postId);
        // 查询帖子评论信息，一并展示在post_content.jsp
        // 根据postId查评论信息
        List<Comment> comments = postService.showCommentInformation(postId);
        session.setAttribute("comments", comments);
        request.getRequestDispatcher("/user/post/post_content.jsp").forward(request, response);
        logger.info("controller-展示讨论帖内容功能结束");
    }

    /**
     * 增加新帖
     *
     * @param post
     * @param request
     * @param response
     */
    @RequestMapping("/addPost")
    public void addPost(Post post, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-新增帖子功能开始");
        if (!PostValidation.publicPostValidate(post)) {
            logger.info("controller-文章信息不合法");
            response.sendRedirect("../user/add_post_fail.jsp");
            return;
        }
        HttpSession session = request.getSession();
        post.setPostId(RandomUtils.generationRandom("post"));
        post.setPostAuthor((String)session.getAttribute("username"));
        post.setViewCount(0);
        post.setCommentCount(0);
        post.setDeleted(PostEnum.NOT_DELETED.getCode());
        post.setSensitive(PostEnum.NOT_SENSITIVE.getCode());
        post.setCreateTime(new Date());
        post.setUpdateTime(new Date());

        int result = postService.addPost(post);

        if (result == 1) {
            logger.info("controller-新增帖子成功");
            showPost(post.getOwnedSection(), request, response);
        } else {
            logger.info("controller-新增帖子失败");
            response.sendRedirect("/user/add_post_fail.jsp");
        }
        logger.info("controller-新增帖子功能结束");
    }

    /**
     * 新增评论
     *
     * @param postContent 帖子的内容，根据这个来找postId，进而找该帖子对应的评论
     * @param gameSectionName 游戏模块，用于页面跳转
     * @param commentContent 要新增的评论的内容
     * @param request
     * @param response
     */
    @RequestMapping("/addComment")
    public void addComment(String postContent, String gameSectionName, String commentContent, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-新增评论功能开始");
        if (!PostValidation.addCommentValidate(commentContent)) {
            logger.info("controller-新增评论功能-内容校验不合法");
            request.setAttribute("failmsg", "请输入评论");
            request.getRequestDispatcher("/user/add_comment_fail.jsp").forward(request, response);
            return;
        }

        // 根据postContent先查postId
        String postId = postService.queryPostIdByPostContent(postContent);

        HttpSession session = request.getSession();
        Comment comment = new Comment();
        comment.setCommentId(RandomUtils.generationRandom("com"));
        comment.setPostId(postId);
        comment.setCommentAuthor((String)session.getAttribute("username"));
        comment.setCommentContent(commentContent);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());

        int result = postService.addComment(comment);

        if (result == 1) {
            logger.info("controller-新增评论功能-新增评论成功");
            // 评论成功，根据评论内容增加帖子评论量
            postService.addCommentCount(postContent);
            session.setAttribute("gameSectionName", gameSectionName);

            // 成功，跳回到列表页
            showPost(gameSectionName, request, response);
        } else {
            // 失败
            logger.info("controller-新增评论功能-新增评论失败");
            response.sendRedirect("/game_forum/user/add_comment_fail.jsp");
        }
        logger.info("controller-新增评论功能结束");
    }

    /**
     * 根据一条评论的commentId回复该评论
     *
     * @param commentId
     * @param replyContent
     * @param gameSectionName
     * @param request
     * @param response
     */
    @RequestMapping("/addReply")
    public void addReply(String commentId, String replyContent, String gameSectionName,
                         HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-回复评论功能开始");
        if (!(PostValidation.addReplyValidate(commentId) && PostValidation.addReplyValidate(replyContent) &&
                PostValidation.addReplyValidate(gameSectionName))) {
            logger.info("controller-回复评论功能-参数校验不合法");
            response.sendRedirect("/game_forum/user/add_reply_comment_fail.jsp");
            return;
        }
        Comment comment = new Comment();
        HttpSession session = request.getSession();

        String postId = postService.queryPostIdByCommentId(commentId);

        comment.setCommentReplyId(commentId);
        comment.setCommentId(RandomUtils.generationRandom("com"));
        comment.setPostId(postId);
        comment.setCommentAuthor((String)session.getAttribute("username"));
        comment.setCommentContent(replyContent);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());

        int result = postService.addReply(comment);
        if (result == 1) {
            logger.info("controller-回复评论成功", comment);
            // 回复成功，增加评论数量
            postService.addCommentCountByPostId(postId);
            showPost(gameSectionName, request, response);
        } else {
            logger.info("controller-回复评论失败", comment);
            response.sendRedirect("/game_forum/user/add_reply_comment_fail.jsp");
        }
        logger.info("controller-回复评论功能结束");
    }

    /**
     * 根据commentId展示评论回复信息
     *
     * @param commentId
     * @param request
     * @param response
     */
    @RequestMapping("/showReplies")
    public void showReplies(String commentId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-展示评论回复信息功能开始");
        List<Comment> replies = postService.showReplies(commentId);

        if (null != replies) {
            logger.info("controller-展示评论回复信息成功", replies);
            request.setAttribute("replies", replies);
            request.getRequestDispatcher("../user/post/all_replied_comment.jsp").forward(request, response);
        }

        logger.info("controller-展示评论回复信息功能结束");
    }
}
