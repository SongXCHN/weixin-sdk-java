package com.github.songxchn.wxpay.v2.bean.result.pay;

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
public class WxPayReverseResult extends BaseWxPayResult {
    private static final long serialVersionUID = -4588641483003862208L;

    /**
     * 是否重调
     * recall
     * 是
     * String(1)
     * Y
     * 是否需要继续调用撤销，Y-需要，N-不需要
     **/
    @XStreamAlias("recall")
    private String isRecall;

    /**
     * 从XML结构中加载额外的熟悉
     *
     * @param d Document
     */
    @Override
    protected void loadXml(Document d) {
        isRecall = readXmlString(d, "recall");
    }

}