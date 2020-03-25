package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 游戏板块
 *
 * @author boomzy
 * @date 2020/3/19 16:55
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSection implements Serializable {
    private BigInteger id;
    private String gameSectionId;
    private String gameSectionName;
    private Date createTime;
    private Date updateTime;
}
