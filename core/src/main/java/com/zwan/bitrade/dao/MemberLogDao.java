package com.zwan.bitrade.dao;

import com.zwan.bitrade.entity.MemberLog;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemberLogDao extends MongoRepository<MemberLog,Long> {
}
