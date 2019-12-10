package com.zwan.bitrade.dao;

import com.zwan.bitrade.constant.CommonStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.OtcCoin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author GS
 * @date 2018年01月12日
 */
public interface OtcCoinDao extends BaseDao<OtcCoin> {

    OtcCoin findOtcCoinByUnitAndStatus(String unit, CommonStatus status);

    List<OtcCoin> findAllByStatus(CommonStatus status);

    OtcCoin findOtcCoinByUnit(String unit);

    @Query("select distinct a.unit from OtcCoin a where a.status = 0")
    List<String> findAllUnits();

}
