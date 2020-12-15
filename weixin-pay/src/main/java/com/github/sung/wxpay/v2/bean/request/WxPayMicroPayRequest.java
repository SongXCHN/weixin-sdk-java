package com.github.sung.wxpay.v2.bean.request;

import com.github.sung.wxcommon.annotation.Required;
import com.github.sung.wxpay.v2.bean.result.WxPayMicroPayResult;
import com.github.sung.wxcommon.exception.WxErrorException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 付款码支付
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_10&index=1">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxPayMicroPayRequest extends BaseWxPayRequest<WxPayMicroPayResult> {
    private static final long serialVersionUID = -9181854528281356167L;

    /**
     * <pre>
     * 设备号
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 终端设备号(商户自定义，如门店编号)
     * </pre>
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * <pre>
     * 字段名：接口版本号.
     * 变量名：version
     * 是否必填：单品优惠必填
     * 类型：String(32)
     * 示例值：1.0
     * 描述：单品优惠新增字段，区分原接口，固定填写1.0
     * 更多信息，详见文档：https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_101&index=1
     * </pre>
     */
    /*@XStreamAlias("version")
    private String version;*/

    /**
     * <pre>
     * 商品描述
     * body
     * 是
     * String(128)
     * image形象店-深圳腾大- QQ公仔
     * 商品或支付单简要描述，格式要求：门店品牌名-城市分店名-实际商品名称
     * </pre>
     **/
    @Required
    @XStreamAlias("body")
    private String body;

    /**
     * <pre>
     * 商品详情
     * detail
     * 否
     * String(6000)
     *
     * 单品优惠功能字段，需要接入请见详细说明
     **/
    @XStreamAlias("detail")
    private String detail;

    /**
     * <pre>
     * 附加数据
     * attach
     * 否
     * String(127)
     * 说明
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     * </pre>
     **/
    @XStreamAlias("attach")
    private String attach;

    /**
     * <pre>
     * 商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     * </pre>
     **/
    @Required
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * <pre>
     * 总金额
     * total_fee
     * 是
     * Int
     * 888
     * 订单总金额，单位为分，只能为整数，详见支付金额
     * </pre>
     **/
    @Required
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * <pre>
     * 货币类型
     * fee_type
     * 否
     * String(16)
     * CNY
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * </pre>
     **/
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * <pre>
     * 终端IP
     * spbill_create_ip
     * 是
     * String(64)
     * 8.8.8.8
     * 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * </pre>
     **/
    @Required
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * <pre>
     * 订单优惠标记
     * goods_tag
     * 否
     * String(32)
     * 订单优惠标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     * </pre>
     **/
    @XStreamAlias("goods_tag")
    private String goodsTag;

    /**
     * <pre>
     * 指定支付方式
     * limit_pay
     * 否
     * String(32)
     * no_credit
     * no_credit--指定不能使用信用卡支付
     * </pre>
     **/
    @XStreamAlias("limit_pay")
    private String limitPay;

    /**
     * <pre>
     * 交易起始时间
     * time_start
     * 否
     * String(14)
     * 20091225091010
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     * </pre>
     */
    @XStreamAlias("time_start")
    private String timeStart;

    /**
     * <pre>
     * 交易结束时间
     * time_expire
     * 否
     * String(14)
     * 20091227091010
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。注意：最短失效时间间隔需大于1分钟
     * </pre>
     */
    @XStreamAlias("time_expire")
    private String timeExpire;

    /**
     * <pre>
     * 付款码
     * auth_code
     * 是
     * String(128)
     * 120061098828009406
     * 扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     * （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     * </pre>
     **/
    @Required
    @XStreamAlias("auth_code")
    private String authCode;


    /**
     * <pre>
     * 电子发票入口开放标识
     * receipt
     * 否
     * String(8)
     * Y
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     * </pre>
     **/
    @XStreamAlias("receipt")
    private String receipt;

    /**
     * <pre>
     * 场景信息.
     * scene_info
     * 否
     * String(256)
     * {"store_info" : {
     * "id": "SZTX001",
     * "name": "腾大餐厅",
     * "area_code": "440305",
     * "address": "科技园中一路腾讯大厦" }}
     * 该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
     * </pre>
     */
    @XStreamAlias("scene_info")
    private String sceneInfo;

    /**
     * <pre>
     * 字段名：是否指定服务商分账.
     * 变量名：profit_sharing
     * 是否必填：否
     * 详情：Y-是，需要分账  N-否，不分账，字母要求大写，不传默认不分账
     * 详细参考 https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=24_3&index=3
     * </pre>
     */
    @XStreamAlias("profit_sharing")
    private String profitSharing;

    @XStreamAlias("user_creid")
    private String userCreid;

    @XStreamAlias("user_truename")
    private String userTruename;



    @Override
    public String routing() {
        return "/pay/micropay";
    }

    @Override
    public Class<WxPayMicroPayResult> getResultClass() {
        return WxPayMicroPayResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("device_info", this.deviceInfo);
        //map.put("version", version);
        map.put("body", this.body);
        map.put("detail", this.detail);
        map.put("attach", this.attach);
        map.put("out_trade_no", this.outTradeNo);
        map.put("total_fee", this.totalFee.toString());
        map.put("fee_type", this.feeType);
        map.put("spbill_create_ip", this.spbillCreateIp);
        map.put("goods_tag", this.goodsTag);
        map.put("limit_pay", this.limitPay);
        map.put("time_start", this.timeStart);
        map.put("time_expire", this.timeExpire);
        map.put("auth_code", this.authCode);
        map.put("receipt", this.receipt);
        map.put("scene_info", this.sceneInfo);
        map.put("profit_sharing", this.profitSharing);
        map.put("user_creid", this.userCreid);
        map.put("user_truename", this.userTruename);
    }
}
