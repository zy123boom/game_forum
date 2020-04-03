package com.boomzy.service.impl;

import com.boomzy.service.SensitiveWordService;
import com.boomzy.util.SensitiveWordInitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author boomzy
 * @date 2020/4/3 10:39
 */
@Service("sensitiveWordService")
public class SensitiveWordServiceImpl implements SensitiveWordService {

    @Autowired
    private SensitiveWordInitUtils sensitiveWordInitUtils;

    @Override
    public int checkSensitiveWord(String content) {
        return 0;
    }
}
