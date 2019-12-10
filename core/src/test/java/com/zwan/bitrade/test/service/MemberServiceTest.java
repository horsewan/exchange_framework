package com.zwan.bitrade.test.service;

import com.zwan.bitrade.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zwan.bitrade.entity.Member;
import com.zwan.bitrade.service.MemberService;


public class MemberServiceTest extends BaseTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void test() {
        Member member=memberService.findOne(25L);
        System.out.println(">>>>>>>>>>>>>>"+member);
        
	}

}
