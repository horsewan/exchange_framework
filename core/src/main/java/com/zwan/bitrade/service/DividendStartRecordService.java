package com.zwan.bitrade.service;

import com.zwan.bitrade.dao.DividendStartRecordDao;
import com.zwan.bitrade.entity.DividendStartRecord;
import com.zwan.bitrade.service.Base.TopBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GS
 * @date 2018年03月22日
 */
@Service
public class DividendStartRecordService extends TopBaseService<DividendStartRecord, DividendStartRecordDao> {

    @Override
    @Autowired
    public void setDao(DividendStartRecordDao dao) {
        super.setDao(dao);
    }

    public List<DividendStartRecord> matchRecord(long start, long end, String unit) {
        return dao.findAllByTimeAndUnit(start, end, unit);
    }

    @Override
    public DividendStartRecord save(DividendStartRecord dividendStartRecord) {
        return dao.save(dividendStartRecord);
    }


}
