package com.boomzy.controller;

import com.boomzy.domain.Opinion;
import com.boomzy.service.OpinionService;
import com.boomzy.util.RandomUtils;
import com.boomzy.validation.OpinionValidation;
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
 * 用户意见控制器层
 *
 * @author boomzy
 * @date 2020/3/13 11:06
 */
@Controller
@RequestMapping("/opinion")
public class OpinionController {

    private static Logger logger = LoggerFactory.getLogger(OpinionController.class);

    @Autowired
    private OpinionService opinionService;

    /**
     * 用户新增意见
     *
     * @param opinionContent
     * @param request
     * @param response
     */
    @RequestMapping("/addOpinion")
    public void addOpinion(String opinionContent, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("controller-用户新增意见功能开始");
        if (!OpinionValidation.addOpinionValidation(opinionContent)) {
            logger.info("controller-用户新增意见失败，参数校验不合法");
            response.sendRedirect("../user/express_opinion_fail.jsp");
            return;
        }
        Opinion opinion = new Opinion();
        HttpSession session = request.getSession();
        opinion.setOpinionId(RandomUtils.generationRandom("op"));
        opinion.setOpinionAuthor((String)session.getAttribute("username"));
        opinion.setOpinionContent(opinionContent);
        opinion.setCreateTime(new Date());
        opinion.setUpdateTime(new Date());
        int result = opinionService.addOpinion(opinion);
        if (result == 1) {
            logger.info("controller-用户新增意见成功");
            // 跳转到展示意见，展示我发表的意见
            List<Opinion> opinions = opinionService.showOpinions(request, response);
            request.setAttribute("opinions", opinions);
            request.getRequestDispatcher("/user/opinion/my_opinion.jsp").forward(request, response);
        } else {
            logger.info("controller-用户新增意见失败");
            response.sendRedirect("../user/express_opinion_fail.jsp");
        }
        logger.info("controller-用户新增意见功能结束");
    }
}
