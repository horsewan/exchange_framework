package com.zwan.bitrade.dao;

import java.util.List;

import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.Coin;
import com.zwan.bitrade.entity.TransferAddress;

/**
 * @author GS
 * @date 2018年02月27日
 */
public interface TransferAddressDao extends BaseDao<TransferAddress> {
    List<TransferAddress> findAllByStatusAndCoin(CommonStatus status, Coin coin);

    TransferAddress findByAddressAndCoin(String address, Coin coin);
}
