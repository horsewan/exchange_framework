package com.zwan.bitrade.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zwan.bitrade.entity.ExchangeTrade;

public interface TradeRepository extends MongoRepository<ExchangeTrade,Long>{
}
