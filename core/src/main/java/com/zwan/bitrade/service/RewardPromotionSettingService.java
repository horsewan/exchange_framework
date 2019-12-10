package com.zwan.bitrade.service;

import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.constant.PromotionRewardType;
import com.zwan.bitrade.dao.RewardPromotionSettingDao;
import cn.ztuo.bitrade.entity.QRewardPromotionSetting;
import com.zwan.bitrade.entity.RewardPromotionSetting;
import com.zwan.bitrade.service.Base.TopBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GS
 * @date 2018年03月08日
 */
@Service
public class RewardPromotionSettingService  extends TopBaseService<RewardPromotionSetting,RewardPromotionSettingDao> {

    @Override
    @Autowired
    public void setDao(RewardPromotionSettingDao dao) {
        super.setDao(dao);
    }

    public RewardPromotionSetting findByType(PromotionRewardType type){
        return dao.findByStatusAndType(BooleanEnum.IS_TRUE, type);
    }

    @Override
    public RewardPromotionSetting save(RewardPromotionSetting setting){
        return dao.save(setting);
    }

    public void deletes(long[] ids){
        for(long id : ids){
            delete(id);
        }
    }

}
