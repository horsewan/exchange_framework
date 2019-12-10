package com.zwan.bitrade.dao;

import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.DataDictionary;

/**
 * @author GS
 * @Title: ${file_name}
 * @Description:
 * @date 2018/4/1214:15
 */
public interface DataDictionaryDao extends BaseDao<DataDictionary> {
    DataDictionary findByBond(String bond);
}
