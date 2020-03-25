package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 用户意见
 *
 * @author boomzy
 * @date 2020/3/13 11:23
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opinion implements Serializable {
    private BigInteger id;
    private String opinionId;
    private String opinionAuthor;
    private String opinionContent;
    private String opinionReply;
    private Date createTime;
    private Date updateTime;
}
