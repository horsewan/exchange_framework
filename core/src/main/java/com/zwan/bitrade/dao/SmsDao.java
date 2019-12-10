package com.zwan.bitrade.dao;

import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.dto.SmsDTO;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @author: GuoShuai
 * @date: create in 9:47 2018/6/28
 * @Modified:
 */
public interface SmsDao extends BaseDao<SmsDTO> {
    
    @Query(value = "select * from tb_sms where sms_status = '0' ",nativeQuery = true)
    SmsDTO findBySmsStatus();
}