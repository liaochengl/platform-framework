package com.lanyang.cloud.framework.pay.domain.jsapi;

import com.lanyang.cloud.framework.pay.enums.PayType;
import io.swagger.annotations.ApiModel;

/**
 * @author lanyang
 * @date 2025/12/18
 * @des
 */
@ApiModel("查询订单参数")
public interface QueryOrderParam {

    PayType getPayType();
}
