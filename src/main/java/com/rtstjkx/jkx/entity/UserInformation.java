package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInformation implements Serializable {
    private Integer id;
    private String userName;//名称
    private String userType;//人员类型ID
    private String userOrg;//操作人员单位ID
    private String userTel;//联系电话
}
