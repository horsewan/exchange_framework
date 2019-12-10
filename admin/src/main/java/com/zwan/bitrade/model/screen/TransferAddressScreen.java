package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.CommonStatus;
import lombok.Data;

@Data
public class TransferAddressScreen {
    private CommonStatus start ;
    private String address;
    private String unit;
}
