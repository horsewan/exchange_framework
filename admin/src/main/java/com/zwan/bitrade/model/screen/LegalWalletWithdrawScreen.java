package com.zwan.bitrade.model.screen;

import com.zwan.bitrade.constant.WithdrawStatus;
import lombok.Data;

@Data
public class LegalWalletWithdrawScreen {
    WithdrawStatus status;
    String username;
    String coinName;

}
