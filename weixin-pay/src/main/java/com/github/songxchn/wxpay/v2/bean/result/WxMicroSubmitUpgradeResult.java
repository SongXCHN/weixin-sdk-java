package com.github.songxchn.wxpay.v2.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxMicroSubmitUpgradeResult extends BaseWxPayResult {
    private static final long serialVersionUID = -6322022067554048901L;


    @Override
    protected void loadXML(Document d) {
    }
}