package com.boomzy.service;

import com.boomzy.domain.Opinion;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户意见
 *
 * @author boomzy
 * @date 2020/3/13 11:20
 */
public interface OpinionService {
    /**
     * 用户新增意见
     *
     * @param opinion
     */
    int addOpinion(Opinion opinion);

    /**
     * 展示用户意见
     *
     * @param request
     * @param response
     * @return
     */
    List<Opinion> showOpinions(HttpServletRequest request, HttpServletResponse response);
}
