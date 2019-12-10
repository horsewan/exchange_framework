package com.zwan.bitrade.processor;

import com.zwan.bitrade.component.CoinExchangeRate;
import com.zwan.bitrade.entity.CoinThumb;
import com.zwan.bitrade.entity.ExchangeTrade;
import com.zwan.bitrade.entity.KLine;
import com.zwan.bitrade.handler.MarketHandler;
import com.zwan.bitrade.service.MarketService;

import java.util.List;

public interface CoinProcessor {

    void setIsHalt(boolean status);

    /**
     * 处理新生成的交易信息
     * @param trades
     * @return
     */
    void process(List<ExchangeTrade> trades);

    /**
     * 添加存储器
     * @param storage
     */
    void addHandler(MarketHandler storage);

    CoinThumb getThumb();

    void setMarketService(MarketService service);

    void generateKLine(int range, int field, long time);

    KLine getKLine();

    void initializeThumb();

    void autoGenerate();

    void resetThumb();

    void setExchangeRate(CoinExchangeRate coinExchangeRate);

    void update24HVolume(long time);

    void initializeUsdRate();
}
