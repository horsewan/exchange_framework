package com.zwan.bitrade.model.screen;

import com.querydsl.core.types.dsl.BooleanExpression;

import com.zwan.bitrade.ability.ScreenAbility;
import com.zwan.bitrade.constant.AdvertiseControlStatus;
import com.zwan.bitrade.entity.QAdvertise;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author GS
 * @Title: ${file_name}
 * @Description:
 * @date 2018/4/2711:45
 */
@Data
public class AdvertiseScreen implements ScreenAbility {

    AdvertiseControlStatus status;

    /**
     * 处理内部断言
     *
     * @return
     */
    @Override
    public ArrayList<BooleanExpression> getBooleanExpressions() {
        ArrayList<BooleanExpression> booleanExpressions = new ArrayList<>();
        if (status != null) {
            booleanExpressions.add(QAdvertise.advertise.status.eq(status));
        }
        return booleanExpressions;
    }


}
