package com.mg.springboot_project.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mg.springboot_project.constant.PublicConstants;
import com.mg.springboot_project.service.JingZhunService;
import com.mg.springboot_project.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author mg
 * @Date 2021-07-07
 * @Version 1.0
 */
@Service
public class JingZhunServiceImpl implements JingZhunService {

	@Value("${jingzhun.username:}")
	private String username;
	@Value("${jingzhun.password:}")
	private String password;
	@Value("${jingzhun.tokenUrl:}")
	private String tokenUrl;
	@Value("${jingzhun.oceanUrl:}")
	private String oceanUrl;
	@Value("${jingzhun.declareUrl:}")
	private String declareUrl;

	@Resource
	private RedisTemplate redisTemplate;

	@Override
	public String getAuthorization() {
		StringBuilder sb = new StringBuilder();
		sb.append("username=");
		sb.append(username);
		sb.append("&password=");
		sb.append(password);
		String result = HttpUtil.sendGet(tokenUrl, sb.toString());
		JSONObject jsonObject= (JSONObject) JSON.parse(result);
		String token="Bearer"+" "+jsonObject.getString("content");

		redisTemplate.opsForValue().set(PublicConstants.JINGZHUN_TOKEN, token);
		redisTemplate.expire(PublicConstants.JINGZHUN_TOKEN, 24, TimeUnit.HOURS);
		return token;
	}

	@Override
	public String getOcean(String params) {
		String token = (String)redisTemplate.opsForValue().get(PublicConstants.JINGZHUN_TOKEN);

		if (token == null) {
			token=this.getAuthorization();
		}

		System.out.println(token);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
		HttpEntity<String> entity = new HttpEntity<>(params, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(oceanUrl,entity,String.class);
		return responseEntity.getBody();
	}

	@Override
	public String getBlnoDeclare(String blno, String ieid) {
		String token = (String)redisTemplate.opsForValue().get(PublicConstants.JINGZHUN_TOKEN);

		if (token == null) {
			token=this.getAuthorization();
		}
		System.out.println(token);
		/*HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Authorization);
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		Map<String,Object> map = new HashMap<>();
		map.put("blno", blno);
		map.put("ieid", ieid);

		HttpEntity<String> request = new HttpEntity<>( headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(declareUrl, HttpMethod.GET, request, String.class,map);
		return responseEntity.getBody();*/
		HashMap<String, String> headerMap = new HashMap<>(2);

		headerMap.put("Authorization", token);
		headerMap.put("Content-Type", "application/json");

		StringBuilder sb = new StringBuilder();
		sb.append("blno=");
		sb.append(blno);
		sb.append("&ieid=");
		sb.append(ieid);

		String s = HttpUtil.sendGet(declareUrl, sb.toString(), headerMap);
		return s;
	}

}
