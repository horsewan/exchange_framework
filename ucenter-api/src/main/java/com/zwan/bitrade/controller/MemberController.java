package com.zwan.bitrade.controller;

import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.constant.SysConstant;
import com.zwan.bitrade.entity.Coin;
import com.zwan.bitrade.entity.Member;
import com.zwan.bitrade.entity.MemberWallet;
import com.zwan.bitrade.entity.Sign;
import com.zwan.bitrade.entity.transform.AuthMember;
import com.zwan.bitrade.service.MemberService;
import com.zwan.bitrade.service.MemberWalletService;
import com.zwan.bitrade.service.SignService;
import com.zwan.bitrade.util.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author GS
 * @Description:
 * @date 2018/5/49:30
 */
@RestController
@RequestMapping("member")
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private SignService signService;
    @Autowired
    private MemberWalletService walletService;

    //签到
    @PostMapping("sign-in")
    public MessageResult signIn(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember user) {
        //校验 签到活动 币种 会员 会员钱包
        Assert.notNull(user, "The login timeout!");

        Sign sign = signService.fetchUnderway();
        Assert.notNull(sign, "The check-in activity is over!");

        Coin coin = sign.getCoin();
        Assert.isTrue(coin.getStatus() == CommonStatus.NORMAL, "coin disabled!");

        Member member = memberService.findOne(user.getId());
        Assert.notNull(member, "validate member id!");
        Assert.isTrue(member.getSignInAbility() == true, "Have already signed in!");

        MemberWallet memberWallet = walletService.findByCoinAndMember(coin, member);
        Assert.notNull(memberWallet, "Member wallet does not exist!");
        Assert.isTrue(memberWallet.getIsLock() == BooleanEnum.IS_FALSE, "Wallet locked!");

        //签到事件
        memberService.signInIncident(member, memberWallet, sign);

        return success();
    }

}
