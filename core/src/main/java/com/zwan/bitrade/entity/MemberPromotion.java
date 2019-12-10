package com.zwan.bitrade.entity;

import com.zwan.bitrade.constant.PromotionLevel;
import lombok.Data;

import javax.persistence.*;

/**
 * @author GS
 * @date 2018年03月08日
 */
@Entity
@Data
public class MemberPromotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    //邀请者Id
    private Long inviterId;
    //受邀者Id
    private Long inviteesId;

    @Enumerated(EnumType.ORDINAL)
    private PromotionLevel level;
}
