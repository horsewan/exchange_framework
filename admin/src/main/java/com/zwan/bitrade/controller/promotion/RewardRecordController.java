package com.zwan.bitrade.controller.promotion;

import com.zwan.bitrade.constant.PageModel;
import com.zwan.bitrade.service.RewardRecordService;
import com.zwan.bitrade.util.MessageResult;

import com.zwan.bitrade.model.RewardRecordScreen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("promotion/reward-record")
public class RewardRecordController {

    @Autowired
    private RewardRecordService rewardRecordService ;

    @PostMapping("page-query")
    public MessageResult page(PageModel pageModel, RewardRecordScreen screen){
        return null;
    }
}
