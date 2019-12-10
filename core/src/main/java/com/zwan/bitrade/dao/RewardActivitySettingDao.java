package com.zwan.bitrade.dao;

import com.zwan.bitrade.constant.ActivityRewardType;
import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.RewardActivitySetting;

/**
 * @author GS
 * @date 2018年03月08日
 */
public interface RewardActivitySettingDao extends BaseDao<RewardActivitySetting> {
    RewardActivitySetting findByStatusAndType(BooleanEnum booleanEnum, ActivityRewardType type);
}
