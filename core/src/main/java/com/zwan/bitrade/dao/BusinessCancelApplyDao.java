package com.zwan.bitrade.dao;

import java.util.List;

import com.zwan.bitrade.constant.CertifiedBusinessStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.BusinessCancelApply;
import com.zwan.bitrade.entity.Member;

/**
 * @author jiangtao
 * @date 2018/5/17
 */
public interface BusinessCancelApplyDao extends BaseDao<BusinessCancelApply> {

    List<BusinessCancelApply> findByMemberAndStatusOrderByIdDesc(Member member , CertifiedBusinessStatus status);

    List<BusinessCancelApply> findByMemberOrderByIdDesc(Member member);

    long countAllByStatus(CertifiedBusinessStatus status);
}
