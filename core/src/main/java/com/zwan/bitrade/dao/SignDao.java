package com.zwan.bitrade.dao;

import com.zwan.bitrade.constant.SignStatus;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.Sign;

/**
 * @author GS
 * @Description:
 * @date 2018/5/311:10
 */
public interface SignDao extends BaseDao<Sign> {
    Sign findByStatus(SignStatus status);
}
