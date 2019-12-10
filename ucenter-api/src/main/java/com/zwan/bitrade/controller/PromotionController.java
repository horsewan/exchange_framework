package com.zwan.bitrade.controller;

import com.zwan.bitrade.constant.PromotionLevel;
import com.zwan.bitrade.entity.Member;
import com.zwan.bitrade.entity.PromotionMember;
import com.zwan.bitrade.entity.PromotionRewardRecord;
import com.zwan.bitrade.entity.RewardRecord;
import com.zwan.bitrade.entity.transform.AuthMember;
import com.zwan.bitrade.service.MemberService;
import com.zwan.bitrade.service.RewardRecordService;
import com.zwan.bitrade.util.MessageResult;

import com.zwan.bitrade.constant.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 推广
 *
 * @author GS
 * @date 2018年03月19日
 */
@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RewardRecordService rewardRecordService;

    /**
     * 推广记录查询
     *
     * @param member
     * @return
     */
//    @RequestMapping(value = "/record")
//    public MessageResult promotionRecord(@SessionAttribute(SESSION_MEMBER) AuthMember member) {
//        List<Member> list = memberService.findPromotionMember(member.getId());
//        List<PromotionMember> list1 = list.stream().map(x ->
//                PromotionMember.builder().createTime(x.getRegistrationTime())
//                        .level(PromotionLevel.ONE)
//                        .username(x.getUsername())
//                        .build()
//        ).collect(Collectors.toList());
//        if (list.size() > 0) {
//            list.stream().forEach(x -> {
//                if (x.getPromotionCode() != null) {
//                    list1.addAll(memberService.findPromotionMember(x.getId()).stream()
//                            .map(y ->
//                                    PromotionMember.builder().createTime(y.getRegistrationTime())
//                                            .level(PromotionLevel.TWO)
//                                            .username(y.getUsername())
//                                            .build()
//                            ).collect(Collectors.toList()));
//                }
//            });
//        }
//        MessageResult messageResult = MessageResult.success();
//        messageResult.setData(list1.stream().sorted((x, y) -> {
//            if (x.getCreateTime().after(y.getCreateTime())) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }).collect(Collectors.toList()));
//        return messageResult;
//    }
    @RequestMapping(value = "/record")
    public MessageResult promotionRecord2(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember member, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        //只查找一级推荐人
        Page<Member> pageList = memberService.findPromotionMemberPage(pageNo-1, pageSize, member.getId());
        MessageResult messageResult = MessageResult.success();
        List<Member> list = pageList.getContent();
        List<PromotionMember> list1 = list.stream().map(x ->
                PromotionMember.builder().createTime(x.getRegistrationTime())
                        .level(PromotionLevel.ONE)
                        .username(x.getUsername())
                        .build()
        ).collect(Collectors.toList());


        messageResult.setData(list1.stream().sorted((x, y) -> {
            if (x.getCreateTime().after(y.getCreateTime())) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList()));

        messageResult.setTotalPage(pageList.getTotalPages() + "");
        messageResult.setTotalElement(pageList.getTotalElements() + "");
        return messageResult;
    }


    /**
     * 推广奖励记录
     *
     * @param member
     * @return
     */
//    @RequestMapping(value = "/reward/record")
//    public MessageResult rewardRecord(@SessionAttribute(SESSION_MEMBER) AuthMember member) {
//        List<RewardRecord> list = rewardRecordService.queryRewardPromotionList(memberService.findOne(member.getId()));
//        MessageResult result = MessageResult.success();
//        result.setData(list.stream().map(x ->
//                PromotionRewardRecord.builder().amount(x.getAmount())
//                        .createTime(x.getCreateTime())
//                        .remark(x.getRemark())
//                        .symbol(x.getCoin().getUnit())
//                        .build()
//        ).collect(Collectors.toList()));
//        return result;
//    }


    /**
     * 只查询推荐奖励
     *
     * @param member
     * @return
     */
    @RequestMapping(value = "/reward/record")
    public MessageResult rewardRecord2(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember member, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<RewardRecord> pageList = rewardRecordService.queryRewardPromotionPage(pageNo, pageSize, memberService.findOne(member.getId()));
        MessageResult result = MessageResult.success();
        List<RewardRecord> list = pageList.getContent();
        result.setData(list.stream().map(x ->
                PromotionRewardRecord.builder().amount(x.getAmount())
                        .createTime(x.getCreateTime())
                        .remark(x.getRemark())
                        .symbol(x.getCoin().getUnit())
                        .build()
        ).collect(Collectors.toList()));

        result.setTotalPage(pageList.getTotalPages() + "");
        result.setTotalElement(pageList.getTotalElements() + "");
        return result;
    }

}
