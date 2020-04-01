package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 敏感词
 *
 * @author boomzy
 * @date 2020/4/1 10:05
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensitiveWord implements Serializable {
    private BigInteger id;
    private String sensitiveWordContent;
    private Date createTime;
    private Date updateTime;
}
