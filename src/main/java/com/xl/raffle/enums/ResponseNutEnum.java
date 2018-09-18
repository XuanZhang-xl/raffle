package com.xl.raffle.enums;

/**
 * 错误码
 * created by MSI-PC on 2018/01/13
 */
public enum ResponseNutEnum {
    OK(0, "成功"),

    GIFT_NOT_FIND(1000, "未找到对应礼物"),
    GIFT_FINISHED(1001, "礼物不足"),
    NO_GIFT_NUM_ANY_MORE(1002, "所有抽奖号码已被抽完, 请重启系统"),



    UNKNOWN_EXCEPTION(9999, "未知异常"),
    ;


    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseNutEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseNutEnum getByCode(Integer code) {
        for (ResponseNutEnum responseNutEnum : ResponseNutEnum.values()) {
            if (responseNutEnum.getCode().equals(code)) {
                return responseNutEnum;
            }
        }
        return null;
    }
}
