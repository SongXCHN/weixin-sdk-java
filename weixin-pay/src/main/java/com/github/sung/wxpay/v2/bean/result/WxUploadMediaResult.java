package com.github.sung.wxpay.v2.bean.result;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxUploadMediaResult extends BaseWxPayResult {
    private static final long serialVersionUID = -2595631560521777952L;
    /**
     * <pre>
     * 媒体标识Id
     * media_id
     * 是
     * String(256)
     * 9UYfXi- WMUhgWXvJtEw4_gBl e_EfrD_pIL0bS8GAsK8
     * 微信返回的媒体文件标识Id
     * </pre>
     **/
    @XStreamAlias("media_id")
    private String mediaId;


    @Override
    protected void loadXML(Document d) {
        this.mediaId = readXMLString(d, "media_id");
    }
}
