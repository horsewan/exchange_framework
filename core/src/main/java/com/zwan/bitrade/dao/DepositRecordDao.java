package com.zwan.bitrade.dao;

import java.util.List;

import com.zwan.bitrade.constant.DepositStatusEnum;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.DepositRecord;
import com.zwan.bitrade.entity.Member;

/**
 * @author zhang yingxin
 * @date 2018/5/7
 */
public interface DepositRecordDao extends BaseDao<DepositRecord> {
    public DepositRecord findById(String id);

    public List<DepositRecord> findByMemberAndStatus(Member member, DepositStatusEnum status);
}
