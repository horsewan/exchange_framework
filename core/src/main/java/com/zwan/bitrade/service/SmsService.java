package com.zwan.bitrade.service;

import com.zwan.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwan.bitrade.dao.SmsDao;
import com.zwan.bitrade.dto.SmsDTO;

/**
 * @Description:
 * @author: GuoShuai
 * @date: create in 9:44 2018/6/28
 * @Modified:
 */
@Service
public class SmsService extends BaseService {
    
    @Autowired
    private SmsDao smsDao;

    /**
     * 获取有效的短信配置
     * @return
     */
    public SmsDTO getByStatus(){
        return smsDao.findBySmsStatus();
    }
    
    
}