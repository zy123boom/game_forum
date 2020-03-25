package com.boomzy.service.impl;

import com.boomzy.dao.OpinionDao;
import com.boomzy.domain.Opinion;
import com.boomzy.service.OpinionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author boomzy
 * @date 2020/3/13 11:22
 */
@Service("opinionService")
public class OpinionServiceImpl implements OpinionService {

    private static Logger logger = LoggerFactory.getLogger(OpinionService.class);

    @Autowired
    private OpinionDao opinionDao;

    @Override
    public int addOpinion(Opinion opinion) {
        logger.info("service-用户新增意见功能开始");
        int result = opinionDao.addOpinion(opinion);
        if (result == 1) {
            logger.info("service-用户新增意见成功");
        } else {
            logger.info("service-用户新增意见失败");
        }
        logger.info("service-用户新增意见功能结束");
        return result;
    }

    @Override
    public List<Opinion> showOpinions(HttpServletRequest request, HttpServletResponse response) {
        logger.info("service-展示用户意见功能开始");
        HttpSession session = request.getSession();
        String opinionAuthor = (String)session.getAttribute("username");
        logger.info("service-展示用户意见功能结束");
        return opinionDao.showOpinions(opinionAuthor);
    }
}
