package com.linkx.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.linkx.util.HttpUtils;

/**
 * @author qings2329
 *
 * @since Jul 17, 2016   5:27:12 PM
 */
public class WeixinSignServlet extends HttpServlet {
	private static final long serialVersionUID = 8149079703144644590L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	private String appID = "wx13e9a0c560426f24";
	private String appSecret = "12bf87ed53197e986563706908905272";
	
	private long expirationTime = 2 * 60 * 60 * 1000;
	private String accessToken = null;
	private String jsApiTicket = null;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	
	private void getAccessToken(){
		String ret = "";
		try{
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
			url = String.format(url, appID, appSecret);
			
//			System.out.println(url);
			ret = HttpUtils.request(url, "get", null);
			System.out.println(ret);
			// {"access_token":"6lZyrE8H6IwGZpSLpNhTchWMUMpvzE45CIS4ZkvZr6pp73b2VRBJUWka0wRfd9UXp17iZV4Q_KoSeByJGKdSSEIycNsmlZF6mV8qHkUAJwUJGKgABAYVZ","expires_in":7200}

		} catch (Exception ex) {
			logger.error("getAccessToken error", ex);
		}
		
	}
	
	
	public static void main(String[] args){
		WeixinSignServlet wx = new WeixinSignServlet();
		wx.getAccessToken();
	}
	
	
}
