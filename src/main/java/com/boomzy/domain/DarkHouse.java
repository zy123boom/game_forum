package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 小黑屋（黑名单）
 *
 * @author boomzy
 * @date 2020/4/2 11:49
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DarkHouse implements Serializable {
    private BigInteger id;
    // 黑名单用户名
    private String darkName;
    private String darkPostId;
    private String darkPostSubject;
    private Date unblockTime;
    private Date createTime;
    private Date updateTime;
}
