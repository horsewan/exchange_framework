package com.zwan.bitrade.test.service;

import com.alibaba.fastjson.JSON;
import com.zwan.bitrade.test.BaseTest;

import com.zwan.bitrade.constant.AdvertiseType;
import com.zwan.bitrade.entity.Advertise;
import com.zwan.bitrade.entity.Member;
import com.zwan.bitrade.service.AdvertiseService;
import com.zwan.bitrade.service.MemberService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author GS
 * @create 2017年12月07日
 * @desc
 */
public class AdvertiseServiceTest extends BaseTest {
    @Autowired
    private AdvertiseService advertiseService;
    @Autowired
    private MemberService memberService;

    @Test
    public void test(){
        Member member = new Member();
        member.setRealName("张金伟");
        member.setUsername("哔啵哔啵");
        Member member1=memberService.save(member);
        Advertise advertise=new Advertise();
        advertise.setMember(member);
        advertise.setAdvertiseType(AdvertiseType.BUY);
        advertise.setCreateTime(new Date());
        Advertise advertise1 = advertiseService.saveAdvertise(advertise);
        System.out.println(JSON.toJSONString(advertise1));
    }
}
