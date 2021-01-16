package com.github.songxchn.wxpay.v3.bean.result.payscore;

import com.github.songxchn.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayScorePermissionOpenidStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6527831756962271406L;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 否
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 授权协议号
     * authorization_code
     * string[1,32]
     * 是
     */
    @SerializedName("authorization_code")
    private String authorizationCode;

    /**
     * 授权状态
     * authorization_state
     * string[1, 16]
     * 是
     */
    @SerializedName("authorization_state")
    private String authorizationState;

    /**
     * 最近一次解除授权时间
     * cancel_authorization_time
     * string[1.32]
     * 否
     */
    @SerializedName("cancel_authorization_time")
    private String cancelAuthorizationTime;

    /**
     * 最近一次授权成功时间
     * authorization_success_time
     * string[1,32]
     * 否
     */
    @SerializedName("authorization_success_time")
    private String authorizationSuccessTime;

}