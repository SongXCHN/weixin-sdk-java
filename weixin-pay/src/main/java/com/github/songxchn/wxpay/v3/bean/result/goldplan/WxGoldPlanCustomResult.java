package com.github.songxchn.wxpay.v3.bean.result.goldplan;

import com.github.songxchn.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxGoldPlanCustomResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -8053030726796976810L;

    /**
     * 特约商户号
     * sub_mchid
     * string[1,32]
     * 是
     */
    @SerializedName("sub_mchid")
    private String subMchid;
}
