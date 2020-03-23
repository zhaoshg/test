package com.zhaoshg;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestEnum {
    ZERO("0", "不通过"),
    ONE("1", "通过"),
    TWO("2", "退回");

    private String code;
    private String msg;
    public Integer getIntCode(){
        return Integer.valueOf(this.getCode());
    }
}
