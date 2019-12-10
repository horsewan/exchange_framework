package com.zwan.bitrade.handler;

import com.zwan.bitrade.entity.ChatMessageRecord;
import com.zwan.bitrade.entity.HistoryChatMessage;
import com.zwan.bitrade.entity.HistoryMessagePage;

public interface MessageHandler {

    void handleMessage(ChatMessageRecord message);

    HistoryMessagePage getHistoryMessage(HistoryChatMessage message);
}
