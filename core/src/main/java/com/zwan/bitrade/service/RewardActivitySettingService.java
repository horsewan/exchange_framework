package com.zwan.bitrade.service;

import com.zwan.bitrade.constant.ActivityRewardType;
import com.zwan.bitrade.constant.BooleanEnum;
import com.zwan.bitrade.dao.RewardActivitySettingDao;
import com.zwan.bitrade.entity.QRewardActivitySetting;
import com.zwan.bitrade.entity.QRewardPromotionSetting;
import com.zwan.bitrade.entity.RewardActivitySetting;
import com.zwan.bitrade.service.Base.TopBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GS
 * @date 2018年03月08日
 */
@Service
public class RewardActivitySettingService extends TopBaseService<RewardActivitySetting,RewardActivitySettingDao> {

    @Override
    @Autowired
    public void setDao(RewardActivitySettingDao dao) {
        this.dao = dao ;
    }


    public RewardActivitySetting findByType(ActivityRewardType type){
        return dao.findByStatusAndType(BooleanEnum.IS_TRUE, type);
    }

    @Override
    public RewardActivitySetting save(RewardActivitySetting rewardActivitySetting){
        return dao.save(rewardActivitySetting);
    }

   /* public List<RewardActivitySetting> page(Predicate predicate){
        Pageable pageable = new PageRequest()
        Iterable<RewardActivitySetting> iterable = rewardActivitySettingDao.findAll(predicate, QRewardActivitySetting.rewardActivitySetting.updateTime.desc());
        return (List<RewardActivitySetting>) iterable ;
    }*/


}
