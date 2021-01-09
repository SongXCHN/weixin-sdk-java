package com.github.songxchn.wxpay.v2.bean.request.redpack;

import com.github.songxchn.common.annotation.Required;
import com.github.songxchn.common.exception.WxErrorException;
import com.github.songxchn.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxchn.wxpay.v2.bean.result.redpack.WxRedPackQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxRedPackQueryRequest extends BaseWxPayRequest<WxRedPackQueryResult> {
    private static final long serialVersionUID = -6693648543917081768L;

    /**
     * 商户订单号
     * mch_billno
     * 是
     * 10000098201411111234567890
     * String(28)
     * 商户订单号（每个订单号必须唯一）
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
     */
    @Required
    @XStreamAlias("mch_billno")
    private String mchBillno;

    /**
     * 订单类型
     * bill_type
     * 是
     * MCHT
     * String(32)
     * MCHT:通过商户订单号获取红包信息。
     */
    @Required
    @XStreamAlias("bill_type")
    private String billType;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"sub_appid", "sub_mch_id", "sign_type"};
    }



    @Override
    public String routing() {
        return "/mmpaymkttransfers/gethbinfo";
    }

    @Override
    public Class<WxRedPackQueryResult> getResultClass() {
        return WxRedPackQueryResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("mch_billno", this.mchBillno);
        map.put("bill_type", this.billType);
    }
}
