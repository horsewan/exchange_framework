package com.zwan.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import com.zwan.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GS
 * @date 2018年01月10日
 */
@AllArgsConstructor
@Getter
public enum BooleanEnum implements BaseEnum {
    IS_FALSE(false, "否"),
    IS_TRUE(true, "是");

    @Setter
    private boolean is;

    @Setter
    private String nameCn;

    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
