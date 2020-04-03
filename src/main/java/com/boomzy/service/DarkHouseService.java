package com.boomzy.service;

import com.boomzy.domain.DarkUser;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/3 18:09
 */
public interface DarkHouseService {

    /**
     * 展示黑名单的用户
     *
     * @return
     */
    List<DarkUser> showDarkUser();
}
