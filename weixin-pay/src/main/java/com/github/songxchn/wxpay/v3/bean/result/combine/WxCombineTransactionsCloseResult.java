package com.github.songxchn.wxpay.v3.bean.result.combine;

import com.github.songxchn.wxpay.v3.bean.result.BaseWxPayV3Result;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxCombineTransactionsCloseResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1581630615723029967L;
}
