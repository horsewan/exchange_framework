package com.zwan.bitrade.dao;

import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.InitPlate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InitPlateDao extends BaseDao<InitPlate> {

    @Query(value = "select * from init_plate where symbol=:symbol" ,nativeQuery = true)
    InitPlate findInitPlateBySymbol(@Param("symbol") String symbol);
}
