package com.github.songxchn.wxpay.v2.bean.result.notify;

import com.github.songxchn.wxpay.v2.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayRefundNotifyResult extends BaseWxPayResult {
    private static final long serialVersionUID = -8840806158886987417L;

    /**
     * 加密信息
     * req_info
     * 是
     * String(1024)
     */
    @XStreamAlias("req_info")
    private String reqInfoStr;

    private ReqInfo reqInfo;



    @Override
    protected void loadXml(Document d) {
        reqInfoStr = readXmlString(d, "req_info");
    }

    /**
     * 加密信息字段解密后的内容.
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @XStreamAlias("root")
    public static class ReqInfo extends BaseWxPayResult {
        private static final long serialVersionUID = -8989854199025924200L;

        /**
         * 微信订单号
         * transaction_id
         * 是
         * String(32)
         */
        @XStreamAlias("transaction_id")
        private String transactionId;

        /**
         * 商户订单号
         * out_trade_no
         * 是
         * String(32)
         */
        @XStreamAlias("out_trade_no")
        private String outTradeNo;

        /**
         * 微信退款单号
         * refund_id
         * 是
         * String(32)
         */
        @XStreamAlias("refund_id")
        private String refundId;

        /**
         * 商户退款单号
         * out_refund_no
         * 是
         * String(64)
         */
        @XStreamAlias("out_refund_no")
        private String outRefundNo;

        /**
         * 订单金额
         * total_fee
         * 是
         * Int
         */
        @XStreamAlias("total_fee")
        private Integer totalFee;

        /**
         * 应结订单金额
         * settlement_total_fee
         * 否
         * Int
         */
        @XStreamAlias("settlement_total_fee")
        private Integer settlementTotalFee;

        /**
         * 申请退款金额
         * refund_fee
         * 是
         * Int
         */
        @XStreamAlias("refund_fee")
        private Integer refundFee;

        /**
         * 退款金额
         * settlement_refund_fee
         * 是
         * Int
         */
        @XStreamAlias("settlement_refund_fee")
        private Integer settlementRefundFee;

        /**
         * 退款状态
         * refund_status
         * 是
         * String(16)
         */
        @XStreamAlias("refund_status")
        private String refundStatus;

        /**
         * 退款成功时间
         * success_time
         * 否
         * String(20)
         */
        @XStreamAlias("success_time")
        private String successTime;

        /**
         * 退款入账账户
         * refund_recv_accout
         * 是
         * String(64)
         */
        @XStreamAlias("refund_recv_accout")
        private String refundRecvAccout;

        /**
         * 退款资金来源
         * refund_account
         * 是
         * String(30)
         */
        @XStreamAlias("refund_account")
        private String refundAccount;

        /**
         * 退款发起来源
         * refund_request_source
         * 是
         * String(30)
         */
        @XStreamAlias("refund_request_source")
        private String refundRequestSource;

        @Override
        protected void loadXml(Document d) {
            transactionId = readXmlString(d, "transaction_id");
            outTradeNo = readXmlString(d, "out_trade_no");
            refundId = readXmlString(d, "refund_id");
            outRefundNo = readXmlString(d, "out_refund_no");
            totalFee = readXmlInteger(d, "total_fee");
            settlementTotalFee = readXmlInteger(d, "settlement_total_fee");
            refundFee = readXmlInteger(d, "refund_fee");
            settlementRefundFee = readXmlInteger(d, "settlement_refund_fee");
            refundStatus = readXmlString(d, "refund_status");
            successTime = readXmlString(d, "success_time");
            refundRecvAccout = readXmlString(d, "refund_recv_accout");
            refundAccount = readXmlString(d, "refund_account");
            refundRequestSource = readXmlString(d, "refund_request_source");
        }
    }


}