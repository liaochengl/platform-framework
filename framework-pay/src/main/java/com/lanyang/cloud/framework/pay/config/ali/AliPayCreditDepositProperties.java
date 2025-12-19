package com.lanyang.cloud.framework.pay.config.ali;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lanyang
 * @date 2025/12/15
 * @des
 */
@ConfigurationProperties(prefix = "alipay.credit")
@Component
public class AliPayCreditDepositProperties {

    /** 信用服务id */
    private static String serviceId;

    /** 信用授权类目*/
    private static String category;

    /** 创建免押订单(线上资金授权冻结接口)结果回调通知地址 */
    private static String freezeNotifyUrl;

    /** 完结免押订单(资金授权解冻接口)结果回调通知地址*/
    private static String unfreezeNotifyUrl;

    /** 取消免押订单(资金授权撤销接口)结果回调通知地址*/
    private static String cancelFreezeNotifyUrl;

    /** 免押扣款(统一收单交易支付接口)结果回调通知地址*/
    private static String payNotifyUrl;

    /** 免押退款(统一收单交易退款接口)结果回调通知地址*/
    private static String refundNotifyUrl;

    public static String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        AliPayCreditDepositProperties.serviceId = serviceId;
    }

    public static String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        AliPayCreditDepositProperties.category = category;
    }

    public static String getFreezeNotifyUrl() {
        return freezeNotifyUrl;
    }

    public void setFreezeNotifyUrl(String freezeNotifyUrl) {
        AliPayCreditDepositProperties.freezeNotifyUrl = freezeNotifyUrl;
    }

    public static String getUnfreezeNotifyUrl() {
        return unfreezeNotifyUrl;
    }

    public void setUnfreezeNotifyUrl(String unfreezeNotifyUrl) {
        AliPayCreditDepositProperties.unfreezeNotifyUrl = unfreezeNotifyUrl;
    }

    public static String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        AliPayCreditDepositProperties.payNotifyUrl = payNotifyUrl;
    }

    public static String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        AliPayCreditDepositProperties.refundNotifyUrl = refundNotifyUrl;
    }

    public static String getCancelFreezeNotifyUrl() {
        return cancelFreezeNotifyUrl;
    }

    public void setCancelFreezeNotifyUrl(String cancelFreezeNotifyUrl) {
        AliPayCreditDepositProperties.cancelFreezeNotifyUrl = cancelFreezeNotifyUrl;
    }
}
