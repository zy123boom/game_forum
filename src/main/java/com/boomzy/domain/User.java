package com.boomzy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 用户
 *
 * @author boomzy
 * @date 2020/2/24 17:51
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private BigInteger id;
    private String userName;
    private String realName;
    private String password;
    private String sex;
    private String email;
    private String province;
    private String city;
    private String userType;
    private Date createTime;
    private Date updateTime;
}
