package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.constant.WithdrawStatus;
import lombok.Data;

@Data
public class WithdrawRecordScreen extends AccountScreen{

    private String unit ;

    /**
     * 提现地址
     */
    private String address ;

    private WithdrawStatus status ;

    /**
     * 是否自动提现
     */
    private BooleanEnum isAuto;

    private Long memberId ;

    private String mobilePhone;

    private String orderSn;
}
