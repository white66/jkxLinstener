package com.rtstjkx.jkx.bean;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class CacheUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;

    private String name;

    private Integer state;

    private String userName;

    private String token;
}
