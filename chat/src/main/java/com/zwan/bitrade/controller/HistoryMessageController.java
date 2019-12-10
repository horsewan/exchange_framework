package com.zwan.bitrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwan.bitrade.entity.HistoryChatMessage;
import com.zwan.bitrade.entity.HistoryMessagePage;
import com.zwan.bitrade.handler.MessageHandler;

@RestController
public class HistoryMessageController {

    @Autowired
    private MessageHandler chatMessageHandler ;

    @RequestMapping("/getHistoryMessage")
    public HistoryMessagePage getHistoryMessage(HistoryChatMessage message){
        return chatMessageHandler.getHistoryMessage(message);
    }
}
