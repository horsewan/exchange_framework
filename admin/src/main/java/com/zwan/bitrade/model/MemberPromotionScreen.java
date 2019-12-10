package com.zwan.bitrade.model;

import com.zwan.bitrade.model.screen.AccountScreen;
import lombok.Data;

@Data
public class MemberPromotionScreen extends AccountScreen {

    private int minPromotionNum = -1;

    private int maxPromotionNum = -1;
}
