package com.zwan.bitrade.service;

import com.zwan.bitrade.constant.LegalWalletState;
import com.zwan.bitrade.service.Base.TopBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import com.zwan.bitrade.dao.LegalWalletRechargeDao;
import com.zwan.bitrade.entity.LegalWalletRecharge;
import com.zwan.bitrade.entity.MemberWallet;
import cn.ztuo.bitrade.entity.QLegalWalletRecharge;
import com.zwan.bitrade.util.BigDecimalUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LegalWalletRechargeService extends TopBaseService<LegalWalletRecharge, LegalWalletRechargeDao> {
    @Autowired
    private LegalWalletRechargeDao legalWalletRechargeDao;


    @Override
    @Autowired
    public void setDao(LegalWalletRechargeDao legalWalletRechargeDao) {
        super.setDao(super.dao = legalWalletRechargeDao);
    }

    //根据用户id,状态,分页
    public Page<LegalWalletRecharge> findAllByMemberIdAndState(long memberId, LegalWalletState state, Integer pageNo, Integer pageSize) {
        Predicate predicate = null;
        if (state != null) {
            predicate = QLegalWalletRecharge.legalWalletRecharge.member.id.eq(memberId)
                    .and(QLegalWalletRecharge.legalWalletRecharge.state.eq(state));
        }
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));
        Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
        return legalWalletRechargeDao.findAll(predicate, pageable);
    }

    //根据用户id,memberId查找
    public LegalWalletRecharge findOneByIdAndMemberId(Long id, long memberId) {
        Predicate predicate = QLegalWalletRecharge.legalWalletRecharge.id.eq(id)
                .and(QLegalWalletRecharge.legalWalletRecharge.member.id.eq(memberId));
        return legalWalletRechargeDao.findOne(predicate);
    }

    public LegalWalletRecharge findOne(Long id) {
        return legalWalletRechargeDao.findOne(id);
    }

    @Override
    public LegalWalletRecharge save(LegalWalletRecharge legalWalletRecharge) {
        return legalWalletRechargeDao.save(legalWalletRecharge);
    }

    //虚假充值处理
    public void noPass(LegalWalletRecharge legalWalletRecharge) {
        legalWalletRecharge.setState(LegalWalletState.DEFEATED);//标记失败
        legalWalletRechargeDao.save(legalWalletRecharge);
    }

    //充值通过
    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public void pass(MemberWallet wallet, LegalWalletRecharge legalWalletRecharge) {
        wallet.setBalance(BigDecimalUtils.add(wallet.getBalance(), legalWalletRecharge.getAmount()));//充值到账
        legalWalletRecharge.setState(LegalWalletState.COMPLETE);//标记完成
    }
}
