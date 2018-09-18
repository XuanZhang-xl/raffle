package com.xl.raffle.enums;

/**
 * 礼物
 * created by XUAN on 2018/03/10
 */
public enum PresentEnum {
    IPHONE_X(1,1),
    DDC(2,2),
    DFB(3, 6),
    YSU(4,10);

    Integer code;

    Integer amount;

    public Integer getCode() {
        return code;
    }

    public Integer getAmount() {
        return amount;
    }

    PresentEnum(Integer code, Integer amount) {
        this.code = code;
        this.amount = amount;
    }
}
