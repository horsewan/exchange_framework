package com.zwan.bitrade.dao;

import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.constant.PromotionRewardType;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.RewardPromotionSetting;

/**
 * @author GS
 * @date 2018年03月08日
 */
public interface RewardPromotionSettingDao extends BaseDao<RewardPromotionSetting> {
    RewardPromotionSetting findByStatusAndType(BooleanEnum booleanEnum, PromotionRewardType type);
}
