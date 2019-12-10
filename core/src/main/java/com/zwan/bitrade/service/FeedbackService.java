package com.zwan.bitrade.service;

import com.zwan.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwan.bitrade.dao.FeedbackDao;
import com.zwan.bitrade.entity.Feedback;

/**
 * @author GS
 * @date 2018年03月19日
 */
@Service
public class FeedbackService extends BaseService {
    @Autowired
    private FeedbackDao feedbackDao;

    public Feedback save(Feedback feedback){
        return feedbackDao.save(feedback);
    }
}
