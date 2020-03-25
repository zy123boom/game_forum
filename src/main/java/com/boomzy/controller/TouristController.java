package com.boomzy.controller;

import com.boomzy.enums.LoginEnum;
import com.boomzy.service.GameSectionService;
import com.boomzy.service.UserService;
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
import java.util.List;

/**
 * 游客控制器
 *
 * @author boomzy
 * @date 2020/3/17 9:54
 */
@Controller
@RequestMapping("/tourist")
public class TouristController {

    private static Logger logger = LoggerFactory.getLogger(TouristController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GameSectionController gameSectionController;

    /**
     * 游客登录
     *
     * @param response
     */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-游客登录功能开始");
        // 使用预埋的值，固定值
        String username = "tourist";
        String password = "123456";
        int result = userService.login(username, password);
        if (result == LoginEnum.SUCCESS.getCode()) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            logger.info("controller-游客登陆成功");
            // 登陆成功在成功界面直接展示游戏模块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/WEB-INF/pages/forum_home.jsp").forward(request, response);
        }
        logger.info("controller-游客登录功能结束");
    }
}
