package com.zwan.bitrade.entity.transform;

import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.constant.MemberLevelEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

import com.zwan.bitrade.entity.Location;
import com.zwan.bitrade.entity.Member;

/**
 * @author GS
 * @date 2018年01月11日
 */
@Builder
@Data
public class AuthMember implements Serializable {
    private static final long serialVersionUID = -4199550203850153635L;
    private long id;
    private String name;
    private String realName;
    private Location location;
    private String mobilePhone;
    private String email;
    private MemberLevelEnum memberLevel;
    private CommonStatus status;

    /**
     * 如需添加信息在{@link #toAuthMember(Member)}方法中添加
     *
     * @param member
     * @return
     */
    public static AuthMember toAuthMember(Member member) {
        return AuthMember.builder()
                .id(member.getId())
                .name(member.getUsername())
                .realName(member.getRealName())
                .location(member.getLocation())
                .mobilePhone(member.getMobilePhone())
                .email(member.getEmail())
                .memberLevel(member.getMemberLevel())
                .status(member.getStatus())
                .build();
    }

}
