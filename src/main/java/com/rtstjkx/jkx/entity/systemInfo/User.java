package com.rtstjkx.jkx.entity.systemInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import java.io.Serializable;
import java.util.Date;

/**
 *用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Date createTime;

    private String email;

    private Date expiredDate;

    private String name;

    private String passWord;

    private String salt;

    private Integer state;

    private String userName;

    private String phone;

    private String org;

    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就不容易被破解，可以采用多种方式定义加盐
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.userName + this.salt;
    }
}
