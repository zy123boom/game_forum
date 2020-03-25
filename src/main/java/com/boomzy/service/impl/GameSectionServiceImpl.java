package com.boomzy.service.impl;

import com.boomzy.dao.GameSectionDao;
import com.boomzy.service.GameSectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/3/3 17:00
 */
@Service("gameSectionService")
public class GameSectionServiceImpl implements GameSectionService {
    private static Logger logger = LoggerFactory.getLogger(GameSectionService.class);

    @Autowired
    private GameSectionDao gameSectionDao;

    @Override
    public List<String> showGameSection() {
        logger.info("service-展示游戏模块功能开始");
        logger.info("service-展示游戏模块功能结束");
        return gameSectionDao.showGameSection();
    }
}
