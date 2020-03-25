package com.boomzy.dao;

import com.boomzy.domain.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户意见
 *
 * @author boomzy
 * @date 2020/3/13 11:38
 */
@Repository
public interface OpinionDao {

    /**
     * 用户新增意见
     *
     * @param opinion
     * @return
     */
    int addOpinion(Opinion opinion);

    /**
     * 展示用户意见
     *
     * @param opinionAuthor
     * @return
     */
    List<Opinion> showOpinions(String opinionAuthor);
}
