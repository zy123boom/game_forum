package com.boomzy.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 游戏模块
 *
 * @author boomzy
 * @date 2020/3/3 17:38
 */
@Repository
public interface GameSectionDao {
    /**
     * 展示所有游戏模块
     *
     * @return
     */
    List<String> showGameSection();
}
