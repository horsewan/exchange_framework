package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.*;
import com.zwan.bitrade.constant.AdvertiseType;
import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.constant.OrderStatus;
import lombok.Data;

@Data
public class AppealScreen {
    private AdvertiseType advertiseType ;
    private String complainant ;//申诉者
    private String negotiant;//交易者
    private BooleanEnum success;
    private String unit ;
    private OrderStatus status ;
    private Boolean auditing = false ;
}
