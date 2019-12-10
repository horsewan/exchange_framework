package com.zwan.bitrade.service;

import com.zwan.bitrade.dao.ExchangeOrderDetailRepository;
import com.zwan.bitrade.dao.ExchangeOrderRepository;
import com.zwan.bitrade.dao.OrderDetailAggregationRepository;
import com.zwan.bitrade.entity.ExchangeOrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ExchangeOrderDetailService {
    @Autowired
    private ExchangeOrderDetailRepository orderDetailRepository;

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository ;

    @Autowired
    private MemberService memberService ;

    @Autowired
    private OrderDetailAggregationRepository orderDetailAggregationRepository;


    /**
     * 查询某订单的成交详情
     * @param orderId
     * @return
     */
    public List<ExchangeOrderDetail> findAllByOrderId(String orderId){
        return orderDetailRepository.findAllByOrderId(orderId);
    }

    public ExchangeOrderDetail save(ExchangeOrderDetail detail){
       return orderDetailRepository.save(detail);
    }
}
