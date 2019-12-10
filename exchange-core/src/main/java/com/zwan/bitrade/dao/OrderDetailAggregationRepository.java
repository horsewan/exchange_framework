package com.zwan.bitrade.dao;

import com.zwan.bitrade.entity.OrderDetailAggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderDetailAggregationRepository extends MongoRepository<OrderDetailAggregation,String>{

    //List<OrderDetailAggregation> findAll(Specification<OrderDetailAggregation> specification);

    //Page<OrderDetailAggregation> findAll(Specification<OrderDetailAggregation> specification, Pageable pageable);

    List<OrderDetailAggregation> findAllByTimeGreaterThanEqualAndTimeLessThanAndUnit(long var1,long var2,String var3);


}

