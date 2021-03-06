package com.github.songxchn.wxpay.v3.bean.result.marketing.busifavor;

import com.github.songxchn.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusifavorCouponSendResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2816391308915980346L;

    /**
     * 消费卡code
     * card_code
     * string[1,15]
     * 是
     */
    @SerializedName("card_code")
    private String cardCode;

}
