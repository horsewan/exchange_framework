package com.zwan.bitrade.service;

import com.zwan.bitrade.constant.CertifiedBusinessStatus;
import com.zwan.bitrade.dao.*;
import com.zwan.bitrade.service.Base.TopBaseService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwan.bitrade.dao.*;
import com.zwan.bitrade.entity.BusinessCancelApply;
import com.zwan.bitrade.entity.Member;

import java.util.List;
import java.util.Map;

@Service
public class BusinessCancelApplyService extends TopBaseService<BusinessCancelApply, BusinessCancelApplyDao> {

    @Override
    @Autowired
    public void setDao(BusinessCancelApplyDao dao) {
        super.setDao(dao);
    }

    @Autowired
    private OrderDao orderDao ;

    @Autowired
    private AppealDao appealDao ;

    @Autowired
    private AdvertiseDao advertiseDao ;

    @Autowired
    private MemberDao memberDao ;


    public List<BusinessCancelApply> findByMemberAndStaus(Member member, CertifiedBusinessStatus status){
        return dao.findByMemberAndStatusOrderByIdDesc(member,status);
    }

    public List<BusinessCancelApply> findByMember(Member member){
        return dao.findByMemberOrderByIdDesc(member);
    }

    public Map<String,Object> getBusinessOrderStatistics(Long memberId) {
       return orderDao.getBusinessStatistics(memberId);
    }

    public  Map<String,Object> getBusinessAppealStatistics(Long memberId){
        Map<String,Object> map = new HashedMap();
        Long complainantNum = appealDao.getBusinessAppealInitiatorIdStatistics(memberId);
        Long defendantNum = appealDao.getBusinessAppealAssociateIdStatistics(memberId);
        map.put("defendantNum",defendantNum);
        map.put("complainantNum",complainantNum);
        return map ;
    }

    public Long getAdvertiserNum(Long memberId) {
        Member member = memberDao.findOne(memberId);
        return advertiseDao.getAdvertiseNum(member);
    }

    public long countAuditing(){
        return dao.countAllByStatus(CertifiedBusinessStatus.CANCEL_AUTH);
    }


}
