package com.zwan.bitrade.dto;

import com.zwan.bitrade.entity.Member;
import com.zwan.bitrade.entity.MemberWallet;
import lombok.Data;

import java.util.List;

@Data
public class MemberDTO {

    private Member member ;

    private List<MemberWallet> list ;

}
