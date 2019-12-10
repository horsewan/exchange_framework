package com.zwan.bitrade.dao;

import com.zwan.bitrade.entity.SysPermission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zwan.bitrade.dao.base.BaseDao;

/**
 * @author GS
 * @date 2017年12月18日
 */
public interface SysPermissionDao extends BaseDao<SysPermission> {

    @Modifying
    @Query(value="delete from admin_role_permission where rule_id = ?1",nativeQuery = true)
    int deletePermission(long permissionId);
}
