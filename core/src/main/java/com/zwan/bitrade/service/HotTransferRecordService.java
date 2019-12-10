package com.zwan.bitrade.service;

import com.zwan.bitrade.service.Base.TopBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwan.bitrade.dao.HotTransferRecordDao;
import com.zwan.bitrade.entity.HotTransferRecord;

@Service
public class HotTransferRecordService extends TopBaseService<HotTransferRecord,HotTransferRecordDao> {

    @Override
    @Autowired
    public void setDao(HotTransferRecordDao dao) {
        super.setDao(dao);
    }
}
