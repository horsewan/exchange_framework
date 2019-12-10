package com.zwan.bitrade.dao;

import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.DividendStartRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author GS
 * @date 2018年03月22日
 */
public interface DividendStartRecordDao extends BaseDao<DividendStartRecord> {

    @Query("select a from DividendStartRecord a where ((a.start<:start and a.end>=:start) or (a.start<:en and a.end>=:en) " +
            " or (a.start>=:start and a.end<:en ) or (a.start<=:start and a.end>:en)) and a.unit=:unit")
    List<DividendStartRecord> findAllByTimeAndUnit(@Param("start") long start, @Param("en") long end, @Param("unit") String unit);
}
