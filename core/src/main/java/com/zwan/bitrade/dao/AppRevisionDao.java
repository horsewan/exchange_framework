package com.zwan.bitrade.dao;

import com.zwan.bitrade.constant.Platform;
import com.zwan.bitrade.dao.base.BaseDao;
import com.zwan.bitrade.entity.AppRevision;

/**
 * @author GS
 * @Title: ${file_name}
 * @Description:
 * @date 2018/4/2416:18
 */
public interface AppRevisionDao extends BaseDao<AppRevision> {
    AppRevision findAppRevisionByPlatformOrderByIdDesc(Platform platform);
}
