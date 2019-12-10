package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.constant.SysAdvertiseLocation;
import lombok.Data;

@Data
public class SysAdvertiseScreen {
    private String serialNumber;
    private SysAdvertiseLocation sysAdvertiseLocation;
    private CommonStatus status;
}
