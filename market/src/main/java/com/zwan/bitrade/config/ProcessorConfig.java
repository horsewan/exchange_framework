package com.zwan.bitrade.config;

import com.zwan.bitrade.component.CoinExchangeRate;
import com.zwan.bitrade.processor.CoinProcessor;
import com.zwan.bitrade.processor.CoinProcessorFactory;
import com.zwan.bitrade.processor.DefaultCoinProcessor;
import com.zwan.bitrade.service.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zwan.bitrade.entity.ExchangeCoin;
import com.zwan.bitrade.handler.MongoMarketHandler;
import com.zwan.bitrade.handler.NettyHandler;
import com.zwan.bitrade.handler.WebsocketMarketHandler;
import com.zwan.bitrade.service.ExchangeCoinService;

import java.util.List;

@Configuration
@Slf4j
public class ProcessorConfig {

    @Bean
    public CoinProcessorFactory processorFactory(MongoMarketHandler mongoMarketHandler,
                                                 WebsocketMarketHandler wsHandler,
                                                 NettyHandler nettyHandler,
                                                 MarketService marketService,
                                                 CoinExchangeRate exchangeRate,
                                                 ExchangeCoinService coinService) {

        log.info("====initialized CoinProcessorFactory start==================================");

        CoinProcessorFactory factory = new CoinProcessorFactory();
        List<ExchangeCoin> coins = coinService.findAllEnabled();
        log.info("exchange-coin result:{}",coins);

        for (ExchangeCoin coin : coins) {
            CoinProcessor processor = new DefaultCoinProcessor(coin.getSymbol(), coin.getBaseSymbol());
            processor.addHandler(mongoMarketHandler);
            processor.addHandler(wsHandler);
            processor.addHandler(nettyHandler);
            processor.setMarketService(marketService);
            processor.setExchangeRate(exchangeRate);
            factory.addProcessor(coin.getSymbol(), processor);
            log.info("new processor = ", processor);
        }

        log.info("====initialized CoinProcessorFactory completed====");
        log.info("CoinProcessorFactory = ", factory);
        exchangeRate.setCoinProcessorFactory(factory);
        return factory;
    }


}
