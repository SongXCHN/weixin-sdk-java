package com.github.songxchn.wxpay.v2.bean.request;

import com.github.songxchn.wxpay.v2.bean.result.WxPayReverseResult;
import com.github.songxchn.common.exception.WxErrorException;
import com.github.songxchn.common.exception.WxErrorExceptionFactor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 撤销订单
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_11&index=3">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxPayReverseRequest extends BaseWxPayRequest<WxPayReverseResult> {
    private static final long serialVersionUID = -1673603732739068431L;


    /**
     * 微信订单号
     * transaction_id
     * 跟out_trade_no二选一
     * String(32)
     * 1217752501201407033233368018
     * 微信的订单号，优先使用
     */
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     * out_trade_no
     * 跟transaction_id二选一
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部的订单号,transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @Override
    public String routing() {
        return "/secapi/pay/reverse";
    }

    @Override
    public Class<WxPayReverseResult> getResultClass() {
        return WxPayReverseResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.transactionId) && StringUtils.isBlank(this.outTradeNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "transaction_id 和 out_trade_no 不能同时为空");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("transaction_id", transactionId);
        map.put("out_trade_no", outTradeNo);
    }
}