package com.linkx.util;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author qings2329
 *
 * @since Jul 17, 2016   10:54:00 PM
 */
public class HttpUtils {
	
	public static String request(String url, String method, List<NameValuePair> params) throws Exception{
		String ret = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try{
			
			if("GET".equalsIgnoreCase(method)){
				if(params != null){
					// ....
				}
				HttpGet httpGet = new HttpGet(url);
//				httpGet.;
				response = httpClient.execute(httpGet);
			} else if("POST".equalsIgnoreCase(method)){
				HttpPost httpPost = new HttpPost(url);
				if(params != null){
					UrlEncodedFormEntity uefEntity  = new UrlEncodedFormEntity(params, "UTF-8");  
					httpPost.setEntity(uefEntity);
				}
				response = httpClient.execute(httpPost);
			} else {
				throw new Exception("invalid method");
			}
			HttpEntity entity = response.getEntity();
			ret = EntityUtils.toString(entity, "UTF-8");
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(response != null){
				response.close();
			}
		}
		
		
		return ret;

	}

}
