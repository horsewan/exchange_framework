package com.zwan.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import com.zwan.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GS
 * @date 2018年01月20日
 */
@AllArgsConstructor
@Getter
public enum PayMode implements BaseEnum {
    ALI("支付宝"), WECHAT("微信"), BANK("银联");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
