package com.boomzy.dao;

import com.boomzy.domain.DarkUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 黑名单持久层
 *
 * @author boomzy
 * @date 2020/4/3 18:14
 */
@Repository
public interface DarkHouseDao {
    /**
     * 展示黑名单用户
     *
     * @return
     */
    List<DarkUser> showDarkUser();

    /**
     * 用户封号
     *
     * @param darkUser
     * @return
     */
    int addUserInDarkHouse(DarkUser darkUser);

    /**
     * 用户解封
     *
     * @param darkName
     * @return
     */
    int deleteFromDarkHome(String darkName);
}
