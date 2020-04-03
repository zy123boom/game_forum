package com.boomzy.service.impl;

import com.boomzy.dao.DarkHouseDao;
import com.boomzy.domain.DarkUser;
import com.boomzy.service.DarkHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boomzy
 * @date 2020/4/3 18:10
 */
@Service("darkHouseService")
public class DarkHouseServiceImpl implements DarkHouseService {

    private static Logger logger = LoggerFactory.getLogger(DarkHouseService.class);

    @Autowired
    private DarkHouseDao darkHouseDao;

    @Override
    public List<DarkUser> showDarkUser() {
        logger.info("service-showDarkUser start");
        List<DarkUser> darkUsers = darkHouseDao.showDarkUser();
        if (null != darkUsers) {
            logger.info("service-showDarkUser success");
        } else {
            logger.info("service-showDarkUser failed");
        }
        logger.info("service-showDarkUser end");
        return darkUsers;
    }

    @Override
    public int addUserInDarkHouse(DarkUser darkUser) {
        logger.info("service-addUserInDarkHouse start");
        int result = 0;
        if (null != darkUser) {
            result = darkHouseDao.addUserInDarkHouse(darkUser);
            if (result == 1) {
                logger.info("service-addUserInDarkHouse success");
            } else {
                logger.info("service-addUserInDarkHouse failed");
            }
        }
        return result;
    }
}
