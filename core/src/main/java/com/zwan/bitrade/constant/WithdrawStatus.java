package com.zwan.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import com.zwan.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author GS
 * @date 2018年02月25日
 */
@AllArgsConstructor
@Getter
public enum WithdrawStatus implements BaseEnum {
    PROCESSING("审核中"),WAITING("等待放币"),FAIL("失败"), SUCCESS("成功");
    private String cnName;
    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
