package com.boomzy.controller;

import com.boomzy.service.GameSectionService;
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
 * 游戏模块控制器层
 *
 * @author boomzy
 * @date 2020/3/3 16:44
 */
@Controller
@RequestMapping("/forum")
public class GameSectionController {
    private static Logger logger = LoggerFactory.getLogger(GameSectionController.class);

    @Autowired
    private GameSectionService gameSectionService;

    @RequestMapping("/showGameSection")
    public void showGameSection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-展示游戏模块功能开始");
        List<String> gameSection = gameSectionService.showGameSection();
        HttpSession session = request.getSession();
        session.setAttribute("gameSection", gameSection);
        logger.info("controller-展示游戏模块功能结束");
    }
}
