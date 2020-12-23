package com.github.sung.wxpay.v3.bean.request.applyment;

import com.github.sung.wxcommon.annotation.Required;
import com.github.sung.wxcommon.exception.WxErrorExceptionFactor;
import com.github.sung.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.sung.wxpay.v3.bean.result.applyment.WxApplymentAuthorizeCancelV3Result;
import com.github.sung.wxcommon.exception.WxErrorException;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * 获取商户开户意愿撤销申请单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/applysubject/chapter5_2.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentAuthorizeCancelV3Request extends BaseWxPayV3Request<WxApplymentAuthorizeCancelV3Result> {
    private static final long serialVersionUID = 8750355463940420185L;


    /**
     * 业务申请编号
     * business_code
     * string(128)
     * 是
     */
    @SerializedName("business_code")
    private String businessCode;

    /**
     * 申请单编号
     * applyment_id
     * uint64
     * 是
     */
    @SerializedName("applyment_id")
    private String applymentId;


    @Override
    public String routing() {
        if (!StringUtils.isBlank(this.businessCode)) {
            return "/v3/apply4subject/applyment/" + this.businessCode + "/cancel";
        } else {
            return "/v3/apply4subject/applyment/" + this.applymentId + "/cancel";
        }
    }

    @Override
    public Class<WxApplymentAuthorizeCancelV3Result> getResultClass() {
        return WxApplymentAuthorizeCancelV3Result.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isAllBlank(this.businessCode, this.applymentId)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "申请单编号与业务申请编号不能都为空");
        }

    }
}
