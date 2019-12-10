package com.zwan.bitrade.dao;

import java.util.List;

import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.BusinessAuthDeposit;

/**
 * @author zhang yingxin
 * @date 2018/5/5
 */
public interface BusinessAuthDepositDao extends BaseDao<BusinessAuthDeposit> {
    public List<BusinessAuthDeposit> findAllByStatus(CommonStatus status);
}
