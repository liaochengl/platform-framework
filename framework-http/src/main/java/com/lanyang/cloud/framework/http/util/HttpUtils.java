package com.lanyang.cloud.framework.http.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author lanyang
 * @date 2024/7/3 15:37
 * @des
 */
@Component
public class HttpUtils {

	@Autowired
	@Qualifier("httpClientRestTemplate")
	private RestTemplate restTemplate;

	public <T> ResponseEntity<T> post(String url, Map<String, String> headMap, Object requestBody, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType=new MediaType("application", "json", StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
		HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);
		if (headMap != null) {
			for (String key : headMap.keySet()) {
				headers.set(key, headMap.get(key));
			}
		}
		ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, entity, responseType);
		return responseEntity;
	}

	public <T> ResponseEntity<T> get(String url, Map<String, String> headMap, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType=new MediaType("application", "json", StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
		if (headMap != null) {
			for (String key : headMap.keySet()) {
				headers.set(key, headMap.get(key));
			}
		}
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
		return responseEntity;
	}

	public <T> ResponseEntity<T> get(String url, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType=new MediaType("application", "json", StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
		return responseEntity;
	}

}
