package com.example.demo;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientTest {
	private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

	@Test
	public void testName() throws Exception {
		URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/token")
				.setParameter("clientId", "your_clientId").setParameter("grant_type", "authorization_code")
				.setParameter("redirect_uri", "http://localhost:8080/callback")
				.setParameter("code", "80d1b0e3dca0f68ff97c7f1d56cdbf6ed266d7a5").build();
		HttpPost httpPost = new HttpPost(uri);
		httpPost.addHeader("Authorization", "Basic encording your_id:your_secret_code into base64");
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(responseString);
		JSONObject json = (JSONObject) object;
		String accessToken = (String) json.get("access_token");
		String scope = (String) json.get("scope");
		String refreshToken = (String) json.get("refresh_token");
		String tokenType = (String) json.get("token_type");
		String userId = (String) json.get("user_id");
//		log.debug("access_token : " + accessToken);
//		log.debug("scope : " + scope);
//		log.debug("refresh_token : " + refreshToken);
//		log.debug("token_type : " + tokenType);
//		log.debug("user_id : " + userId);
		// --------------------------------------------------------------------
//		URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/1/user/-/profile.json").build();
//		HttpPost httpPost = new HttpPost(uri);
//		httpPost.addHeader("Authorization",
//				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0R0RNN1Ai"
//						+ "LCJhdWQiOiIyMkNaVzkiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29"
//						+ "wZXMiOiJ3cHJvIiwiZXhwIjoxNTI5MzAzNTU0LCJpYXQiOjE1MjkyNzQ3NTR9.S36yfRc1UfWnCB"
//						+ "TgyvM61baH5DKZg0vcUShShl6Qqzc\n" + "");
//
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		CloseableHttpResponse response = httpclient.execute(httpPost);
//		HttpEntity entity = response.getEntity();
//		String responseString = EntityUtils.toString(entity, "UTF-8");
//		System.out.println(responseString);
//		parser = new JSONParser();
//		object = parser.parse(responseString);
//		json = (JSONObject) object;
//		accessToken = (String) json.get("access_token");
//		scope = (String) json.get("scope");
//		refreshToken = (String) json.get("refresh_token");
//		tokenType = (String) json.get("token_type");
//		userId = (String) json.get("user_id");
//		log.debug("access_token : " + accessToken);
//		log.debug("scope : " + scope);
//		log.debug("refresh_token : " + refreshToken);
//		log.debug("token_type : " + tokenType);
//		log.debug("user_id : " + userId);

	}

}
