package com.zwan.bitrade.entity;

import com.zwan.bitrade.constant.BooleanEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author GS
 * @date 2018年01月29日
 */
@Builder
@Data
public class WithdrawWalletInfo {
    private String unit;
    /**
     * 阈值
     */
    private BigDecimal threshold;
    /**
     * 最小提币数量
     */
    private BigDecimal minAmount;
    /**
     * 最大提币数量
     */
    private BigDecimal maxAmount;
    private double minTxFee;
    private double maxTxFee;
    private String nameCn;
    private String name;
    private BigDecimal balance;
    private BooleanEnum canAutoWithdraw;
    private int withdrawScale;
    /**
     * 地址
     */
    private List<Map<String,String>> addresses;
}
