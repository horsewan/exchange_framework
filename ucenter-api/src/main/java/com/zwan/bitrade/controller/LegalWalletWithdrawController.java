package com.zwan.bitrade.controller;

import com.querydsl.core.types.dsl.BooleanExpression;

import com.zwan.bitrade.constant.PageModel;
import com.zwan.bitrade.constant.WithdrawStatus;
import cn.ztuo.bitrade.entity.*;
import com.zwan.bitrade.entity.*;
import com.zwan.bitrade.entity.transform.AuthMember;
import com.zwan.bitrade.service.CoinService;
import com.zwan.bitrade.service.LegalWalletWithdrawService;
import com.zwan.bitrade.service.MemberService;
import com.zwan.bitrade.service.MemberWalletService;
import com.zwan.bitrade.util.BigDecimalUtils;
import com.zwan.bitrade.util.BindingResultUtil;
import com.zwan.bitrade.util.MessageResult;

import com.zwan.bitrade.constant.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 提现
 */
@RestController
@RequestMapping("legal-wallet-withdraw")
public class LegalWalletWithdrawController extends BaseController {
    @Autowired
    private LegalWalletWithdrawService legalWalletWithdrawService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CoinService coinService;
    @Autowired
    private MemberWalletService walletService;

    @GetMapping()
    public MessageResult page(
            PageModel pageModel,
            @RequestParam(value = "state", required = false) WithdrawStatus status,
            @SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember user) {
        BooleanExpression eq = QLegalWalletWithdraw.legalWalletWithdraw.member.id.eq(user.getId());
        if (status != null) {
            eq.and(QLegalWalletWithdraw.legalWalletWithdraw.status.eq(status));
        }
        Page<LegalWalletWithdraw> page = legalWalletWithdrawService.findAll(eq, pageModel);
        return success(page);
    }

    @PostMapping()
    public MessageResult post(
            LegalWalletWithdrawModel model,
            BindingResult bindingResult,
            @SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember user) {
        MessageResult result = BindingResultUtil.validate(bindingResult);
        if (result != null) {
            return result;
        }
        // 合法币种
        Coin coin = coinService.findByUnit(model.getUnit());
        Assert.notNull(coin, "validate coin name!");
        Assert.isTrue(coin.getHasLegal(), "validate coin name!");
        //用户提现的币种钱包
        MemberWallet wallet = walletService.findOneByCoinNameAndMemberId(coin.getName(), user.getId());
        Assert.notNull(wallet, "wallet null!");
        Assert.isTrue(BigDecimalUtils.compare(wallet.getBalance(), model.getAmount()), "insufficient balance!");
        //提现人
        Member member = memberService.findOne(user.getId());
        Assert.notNull(member, "validate login user!");
        //创建 提现
        LegalWalletWithdraw legalWalletWithdraw = new LegalWalletWithdraw();
        legalWalletWithdraw.setMember(member);
        legalWalletWithdraw.setCoin(coin);
        legalWalletWithdraw.setAmount(model.getAmount());
        legalWalletWithdraw.setPayMode(model.getPayMode());
        legalWalletWithdraw.setStatus(WithdrawStatus.PROCESSING);
        legalWalletWithdraw.setRemark(model.getRemark());
        //提现操作
        legalWalletWithdrawService.withdraw(wallet, legalWalletWithdraw);
        return success();
    }

    @GetMapping("{id}")
    public MessageResult detail(
            @PathVariable Long id,
            @SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember user) {
        LegalWalletWithdraw one = legalWalletWithdrawService.findDetailWeb(id, user.getId());
        Assert.notNull(one, "validate id!");
        return success(one);
    }

}
