package com.boomzy.controller;

import com.boomzy.domain.User;
import com.boomzy.enums.LoginEnum;
import com.boomzy.enums.RegisterEnum;
import com.boomzy.enums.UserTypeEnum;
import com.boomzy.service.UserService;
import com.boomzy.validation.UserValidation;
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

/**
 * 用户控制器
 *
 * @author boomzy
 * @date 2020/2/24 18:00
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GameSectionController gameSectionController;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        logger.info("controller层登陆功能开始");
//        String username = request.getParameter("userName");
//        String password = request.getParameter("password");
        if (!UserValidation.loginValidation(username, password)) {
            logger.info("controller-用户名或密码不合法");
            request.setAttribute("failmsg", "用户名或密码不合法");
            request.getRequestDispatcher("/user/login_fail.jsp").forward(request, response);
            return;
        }
        int loginResult = userService.login(username, password);
        if (loginResult == LoginEnum.SUCCESS.getCode()) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            logger.info("controller-登陆成功");
            // 登陆成功在成功界面直接展示游戏模块
            gameSectionController.showGameSection(request, response);
            request.getRequestDispatcher("/WEB-INF/pages/forum_home.jsp").forward(request, response);
            return;
        }
        if (loginResult == LoginEnum.LOGIN_FAIL.getCode()) {
            logger.info("controller-用户名或密码错误");
            request.setAttribute("failmsg", "用户名或密码错误");
            request.getRequestDispatcher("/user/login_fail.jsp").forward(request, response);
            logger.info("controller层登陆功能结束");
            return;
        }
        if (loginResult == LoginEnum.USER_IN_DARK.getCode()) {
            logger.info("controller-用户已被封号");
            request.setAttribute("failmsg", "用户已被封号");
            response.sendRedirect("user_blocked.jsp");
            logger.info("controller层登陆功能结束");
            return;
        }
        response.sendRedirect("login_error.jsp");
        logger.info("controller层登陆功能结束");
    }

    /**
     * 用户注册
     *
     * @param user
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/register")
    public void register(User user, HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        logger.info("controller层注册功能开始");
        String confirmPassword = request.getParameter("confirmPassword");
        if (!UserValidation.registerValidation(user, confirmPassword)) {
            logger.info("controller-注册验证失败");
            request.setAttribute("failmsg", "注册验证失败");
            request.getRequestDispatcher("/user/register_fail.jsp").forward(request, response);
            return;
        }
        // 查询用户名是否重复
        int count = userService.queryUserNameCount(user.getUserName());
        if (count >= 1) {
            logger.info("controller-注册失败，用户名重复");
            request.setAttribute("failmsg", "用户名重复");
            request.getRequestDispatcher("/user/register_fail.jsp").forward(request, response);
            return;
        }
        user.setUserType(UserTypeEnum.NORMAL_USER.getCode());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int result = userService.register(user);
        if (result == RegisterEnum.SUCCESS.getCode()) {
            logger.info("controller-注册成功");
            request.getRequestDispatcher("/user/register_success.jsp").forward(request, response);
            return;
        }
        if (result == RegisterEnum.REGISTER_FAIL.getCode()) {
            logger.info("controller-注册信息不合法");
            request.setAttribute("failmsg", "注册信息不合法");
            request.getRequestDispatcher("/user/register_fail.jsp").forward(request, response);
            return;
        }
        logger.info("controller-注册功能结束");
    }

    /**
     * 修改密码
     *
     * @param request
     * @param response
     */
    @RequestMapping("/updatePassword")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-修改密码功能开始");
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (!(UserValidation.genericValidation(username) && UserValidation.genericValidation(oldPassword)
            && UserValidation.genericValidation(newPassword) && UserValidation.genericValidation(confirmPassword))) {
            logger.info("controller-修改密码功能失败，参数校验不合法");
            request.setAttribute("failmsg", "参数校验不合法");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-修改密码功能结束");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            logger.info("controller-修改密码失败，密码验证不一致");
            request.setAttribute("failmsg", "两次输入密码不一致");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-修改密码功能结束");
            return;
        }

        int loginResult = userService.login(username, oldPassword);
        if (loginResult != LoginEnum.SUCCESS.getCode()) {
            logger.info("controller-修改密码失败，账户密码错误");
            request.setAttribute("failmsg", "账户密码错误");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-修改密码功能结束");
            return;
        }

        // 修改密码
        int result = userService.updatePassword(username, oldPassword, newPassword);

        if (result == LoginEnum.SUCCESS.getCode()) {
            logger.info("controller-修改密码成功！");
            // 修改完后重新登陆
            request.getRequestDispatcher("../invalidate.jsp").forward(request, response);
        } else {
            logger.info("controller-修改密码失败，系统错误");
            response.sendRedirect("update_password_fail.jsp");
        }
        logger.info("controller-修改密码结束");
    }

    /**
     * 忘记密码的密码更新
     *
     * @param request
     * @param response
     */
    @RequestMapping("/updatePasswordByForget")
    public void updatePasswordByForget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("service-updatePasswordByForget 开始");
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (!(UserValidation.genericValidation(username) && UserValidation.genericValidation(newPassword) &&
                UserValidation.genericValidation(confirmPassword))) {
            logger.info("controller-updatePasswordByForget 失败，参数校验不合法");
            request.setAttribute("failmsg", "参数校验不合法");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-updatePasswordByForget 功能结束");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            logger.info("controller-updatePasswordByForget 失败，密码验证不一致");
            request.setAttribute("failmsg", "两次输入密码不一致");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-updatePasswordByForget 结束");
            return;
        }

        // 判断该用户是否存在
        int count = userService.queryUserByUserName(username);
        if (count < 1) {
            logger.info("controller-updatePasswordByForget 失败，用户不存在");
            request.setAttribute("failmsg", "用户不存在");
            request.getRequestDispatcher("/user/update_password_fail.jsp").forward(request, response);
            logger.info("controller-updatePasswordByForget 结束");
            return;
        }

        // 修改密码
        int result = userService.updatePasswordByUsername(username, newPassword);

        if (result == LoginEnum.SUCCESS.getCode()) {
            logger.info("controller-updatePasswordByForget 成功！");
            // 修改完后重新登陆
            request.getRequestDispatcher("../invalidate.jsp").forward(request, response);
        } else {
            logger.info("controller-updatePasswordByForget 失败，系统错误");
            response.sendRedirect("update_password_fail.jsp");
        }
        logger.info("controller-updatePasswordByForget 结束");
    }

    /**
     * 展示用户信息
     *
     * @param username
     * @param request
     * @param response
     */
    @RequestMapping("/showUserInformation")
    public void showUserInformation(String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("controller-展示用户信息功能开始");
        if (null != username) {
            User user = userService.showUserInformation(username);
            if (null != user) {
                logger.info("controller-展示用户信息成功");
                request.setAttribute("user", user);
                request.getRequestDispatcher("/user/user_information.jsp").forward(request, response);
            } else {
                logger.info("controller-展示用户信息失败");
                response.sendRedirect("show_information_fail.jsp");
            }
        }
        logger.info("controller-展示用户信息功能结束");
    }

}
