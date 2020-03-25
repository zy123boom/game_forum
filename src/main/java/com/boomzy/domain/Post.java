package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * 帖子
 *
 * @author boomzy
 * @date 2020/3/4 16:31
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private BigInteger id;
    private String postId;
    private String ownedSection;
    private String postSubject;
    private String postContent;
    private String postAuthor;
    private Integer viewCount;
    private Integer commentCount;
    private String deleted;
    private String sensitive;
    private Date createTime;
    private Date updateTime;
}
