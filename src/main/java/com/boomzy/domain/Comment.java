package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 评论信息
 *
 * @author boomzy
 * @date 2020/3/10 11:12
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private BigInteger id;
    private String commentId;
    private String postId;
    // 回复评论的回复编号
    private String commentReplyId;
    private String commentAuthor;
    private String commentContent;
    private Date createTime;
    private Date updateTime;
}
