package com.lanyang.cloud.framework.message.util;

import com.lanyang.cloud.framework.http.util.HttpUtils;
import com.lanyang.cloud.framework.message.config.WechatMessageConfig;
import com.lanyang.cloud.framework.message.constant.RedisCacheConstant;
import com.lanyang.cloud.framework.message.constant.WechatMessageConstant;
import com.lanyang.cloud.framework.message.domain.dto.WechatAccessTokenResponseDTO;
import com.lanyang.cloud.framework.message.domain.dto.WechatMessageDTO;
import com.lanyang.cloud.framework.message.domain.dto.WechatMessageResponseDTO;
import com.lanyang.cloud.framework.message.domain.vo.WechatMessageVO;
import com.lanyang.cloud.framework.message.exception.MessageException;
import com.lanyang.cloud.framework.redis.service.RedisUtils;
import com.lanyang.framework.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lanyang
 * @date 2024/7/5 16:22
 * @des
 */
@Component
public class WechatMessageUtils {

//    private static final String WECHAT_SERVER = "";
//
//    private static final String TEMPLATE_MESSAGE_URL = "";
//
//    private static final String SUBSCRIBE_MESSAGE_URL = "";

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private RedisUtils redisService;
    @Autowired
    private WechatMessageConfig wechatMessageConfig;

    /**
     * 发送模板消息
     * @param message
     * @return
     */
    public String sendTemplateMessage(WechatMessageVO message) {

        String accessToken = this.getAccessToken();

        String url = String.format(wechatMessageConfig.getServer() + wechatMessageConfig.getTemplateMessageUrl(), accessToken);

        WechatMessageDTO messageDTO = this.buildMessage(message);
        ResponseEntity<String> responseEntity = httpUtils.post(url, null, messageDTO, String.class);
        WechatMessageResponseDTO messageResponse = JsonUtils.formatJson2Bean(responseEntity.getBody(), WechatMessageResponseDTO.class);
        if(!WechatMessageConstant.message_success.equals(messageResponse.getErrcode())){
            throw new MessageException(messageResponse.getErrcode(), "发送模板消息失败");
        }
        return messageResponse.getMsgid();

    }

    /**
     * 发送订阅消息
     * @param message
     * @return
     */
    public String sendSubscribeMessage(WechatMessageVO message) {


        String accessToken = this.getAccessToken();

        String url = String.format(wechatMessageConfig.getServer() + wechatMessageConfig.getSubscribeMessageUrl(), accessToken);

        WechatMessageDTO messageDTO = this.buildMessage(message);
        ResponseEntity<String> responseEntity = httpUtils.post(url, null, messageDTO, String.class);
        WechatMessageResponseDTO messageResponse = JsonUtils.formatJson2Bean(responseEntity.getBody(), WechatMessageResponseDTO.class);
        if(!WechatMessageConstant.message_success.equals(messageResponse.getErrcode())){
            throw new MessageException(messageResponse.getErrcode(), "发送订阅消息失败:" + messageResponse.getErrmsg());
        }
        return messageResponse.getMsgid();
    }

    /**
     * 获取accessToken，有效期是两小时，获取后存redis，优先取redis，没有则重新获取
     * @param appId
     * @return
     */
    private String getAccessToken(String appId){

        //直接取缓存
        String accessTokenCacheKey = RedisCacheConstant.WECHAT_ACCESS_TOKEN + appId;
        String accessToken = redisService.getCacheObject(accessTokenCacheKey);
        if(StringUtils.isNotBlank(accessToken)){
            return accessToken;
        }

//        Map<String, String> app = wechatMessageConfig.getApp();
//        if(MapUtils.isEmpty(app) || !app.containsKey(appId)){
//            throw new ServiceException("appId未配置");
//        }
        String url = String.format(wechatMessageConfig.getServer() + wechatMessageConfig.getTokenUrl(), wechatMessageConfig.getAppId(), wechatMessageConfig.getAppSecret());
        ResponseEntity<String> responseEntity = httpUtils.get(url, String.class);
        WechatAccessTokenResponseDTO accessTokenResponse = JsonUtils.formatJson2Bean(responseEntity.getBody(), WechatAccessTokenResponseDTO.class);
        if(Objects.isNull(accessTokenResponse) || StringUtils.isBlank(accessTokenResponse.getAccess_token())){
            throw new MessageException(500, "发送消息失败");
        }
        redisService.setCacheObject(accessTokenCacheKey, accessTokenResponse.getAccess_token(), accessTokenResponse.getExpires_in(), TimeUnit.SECONDS);
        return accessTokenResponse.getAccess_token();
    }

    /**
     * 获取accessToken，有效期是两小时，获取后存redis，优先取redis，没有则重新获取
     * @return
     */
    private String getAccessToken(){

        if(StringUtils.isBlank(wechatMessageConfig.getAppId())){
            throw new MessageException(500, "appId未配置");
        }

        //直接取缓存
        String accessTokenCacheKey = RedisCacheConstant.WECHAT_ACCESS_TOKEN + wechatMessageConfig.getAppId();
        String accessToken = redisService.getCacheObject(accessTokenCacheKey);
        if(StringUtils.isNotBlank(accessToken)){
            return accessToken;
        }

        String url = String.format(wechatMessageConfig.getServer() + wechatMessageConfig.getTokenUrl(), wechatMessageConfig.getAppId(), wechatMessageConfig.getAppSecret());
        ResponseEntity<String> responseEntity = httpUtils.get(url, String.class);
        WechatAccessTokenResponseDTO accessTokenResponse = JsonUtils.formatJson2Bean(responseEntity.getBody(), WechatAccessTokenResponseDTO.class);
        if(Objects.isNull(accessTokenResponse) || StringUtils.isBlank(accessTokenResponse.getAccess_token())){
            throw new MessageException(500,"发送消息失败");
        }
        redisService.setCacheObject(accessTokenCacheKey, accessTokenResponse.getAccess_token(), accessTokenResponse.getExpires_in(), TimeUnit.SECONDS);
        return accessTokenResponse.getAccess_token();
    }

    /**
     * 构建消息发送请求参数
     * @param message
     * @return
     */
    private WechatMessageDTO buildMessage(WechatMessageVO message){

        WechatMessageDTO wechatMessageDTO = new WechatMessageDTO();
        wechatMessageDTO.setTouser(message.getTargetUser());
        wechatMessageDTO.setTemplate_id(message.getTemplateId());

        //模板参数按照微信的格式要求组装
        Map<String, Map<String, Object>> data = new HashMap<>();
        Set<Map.Entry<String, Object>> entries = message.getData().entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Map<String, Object> item = new HashMap<>();
            item.put("value", entry.getValue());
            data.put(entry.getKey(), item);
        }
        wechatMessageDTO.setData(data);

        //跳转配置
        wechatMessageDTO.setPage(message.getPage());
        wechatMessageDTO.setMiniprogram_state(message.getMiniProgramState());

        return wechatMessageDTO;
    }
}
