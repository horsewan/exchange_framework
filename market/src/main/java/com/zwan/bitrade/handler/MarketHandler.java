package com.zwan.bitrade.handler;

import com.zwan.bitrade.entity.CoinThumb;
import com.zwan.bitrade.entity.ExchangeTrade;
import com.zwan.bitrade.entity.KLine;

public interface MarketHandler {

    /**
     * 存储交易信息
     * @param exchangeTrade
     */
    void handleTrade(String symbol, ExchangeTrade exchangeTrade, CoinThumb thumb);


    /**
     * 存储K线信息
     *
     * @param kLine
     */
    void handleKLine(String symbol,KLine kLine);
}
