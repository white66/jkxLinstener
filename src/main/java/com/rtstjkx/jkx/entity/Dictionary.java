package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dictionary implements Serializable {
    private Integer Dic_ID;
    private String Dic_Type;
    private String Dic_TypeName;
    private String Dic_Value;
    private String Dic_ValueName;
    private Integer Dic_Sort;
}
