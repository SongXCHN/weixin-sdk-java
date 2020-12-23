package com.github.sung.wxpay.v3.bean.request.applyment;

import com.github.sung.wxcommon.exception.WxErrorExceptionFactor;
import com.github.sung.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.sung.wxpay.v3.bean.result.applyment.WxApplymentAuthorizeSubStateV3Result;
import com.github.sung.wxcommon.exception.WxErrorException;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * 获取商户开户意愿查询申请单审核结果API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/applysubject/chapter5_3.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentAuthorizeSubStateV3Request extends BaseWxPayV3Request<WxApplymentAuthorizeSubStateV3Result> {
    private static final long serialVersionUID = -4629107064469064525L;


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
            return "/v3/apply4subject/applyment?business_code=" + this.businessCode;
        } else {
            return "/v3/apply4subject/applyment?applyment_id=" + this.applymentId;
        }
    }

    @Override
    public Class<WxApplymentAuthorizeSubStateV3Result> getResultClass() {
        return WxApplymentAuthorizeSubStateV3Result.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isAllBlank(this.businessCode, this.applymentId)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "申请单编号与业务申请编号不能都为空");
        }
    }
}
