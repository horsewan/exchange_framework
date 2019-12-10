package com.zwan.bitrade.controller;

import com.zwan.bitrade.coin.CoinExchangeFactory;
import com.zwan.bitrade.service.OtcCoinService;
import com.zwan.bitrade.util.MessageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.zwan.bitrade.util.MessageResult.success;

import java.util.List;
import java.util.Map;

/**
 * @author GS
 * @date 2018年01月06日
 */
@RestController
@Slf4j
@RequestMapping(value = "/coin")
public class OtcCoinController {

    @Autowired
    private OtcCoinService coinService;
    @Autowired
    private CoinExchangeFactory coins;

    /**
     * 取得正常的币种
     *
     * @return
     */
    @RequestMapping(value = "all")
    public MessageResult allCoin() throws Exception {
        List<Map<String, String>> list = coinService.getAllNormalCoin();
        list.stream().forEachOrdered(x ->{
            if(coins.get(x.get("unit")) != null) {
                x.put("marketPrice", coins.get(x.get("unit")).toString());
            }
        });
        MessageResult result = success();
        result.setData(list);
        return result;
    }
}
