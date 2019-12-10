package com.zwan.bitrade.dao;

import java.util.List;

import com.zwan.bitrade.constant.CertifiedBusinessStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.BusinessAuthApply;
import com.zwan.bitrade.entity.Member;

/**
 * @author zhang yingxin
 * @date 2018/5/7
 */
public interface BusinessAuthApplyDao extends BaseDao<BusinessAuthApply> {

    List<BusinessAuthApply> findByMemberOrderByIdDesc(Member member);

    List<BusinessAuthApply> findByMemberAndCertifiedBusinessStatusOrderByIdDesc(Member member, CertifiedBusinessStatus certifiedBusinessStatus);

    long countAllByCertifiedBusinessStatus(CertifiedBusinessStatus status);

}
