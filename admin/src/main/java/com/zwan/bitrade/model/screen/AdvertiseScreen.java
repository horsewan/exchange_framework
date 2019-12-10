package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.AdvertiseControlStatus;
import com.zwan.bitrade.constant.AdvertiseType;
import lombok.Data;

@Data
public class AdvertiseScreen extends AccountScreen{

    AdvertiseType advertiseType;

    String payModel ;

    /**
     * 广告状态 (012  上架/下架/关闭)
     */
    AdvertiseControlStatus status ;

}
