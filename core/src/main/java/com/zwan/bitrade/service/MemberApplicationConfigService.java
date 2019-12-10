package com.zwan.bitrade.service;

import com.zwan.bitrade.service.Base.TopBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwan.bitrade.dao.MemberApplicationConfigDao;
import com.zwan.bitrade.entity.MemberApplicationConfig;

import java.util.List;

@Service
public class MemberApplicationConfigService extends TopBaseService<MemberApplicationConfig,MemberApplicationConfigDao> {

    @Override
    @Autowired
    public void setDao(MemberApplicationConfigDao dao) {
        super.setDao(dao);
    }

    public MemberApplicationConfig get(){
        List<MemberApplicationConfig> list = dao.findAll() ;
        return list!=null&&list.size()>0 ? list.get(0) : null;
    }
}
