package com.github.songxchn.wxpay.v3.bean.result.smartguide;

import com.github.songxchn.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxSmartGuideRegisterResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 3855072732695127221L;

    /**
     * 服务人员ID
     * guide_id
     * string[1,32]
     * 是
     */
    @SerializedName("guide_id")
    private String guideId;
}
