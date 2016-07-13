package com.linkx.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.linkx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		StringBuffer sb = new StringBuffer();
		String jsoncallback=req.getParameter("jsoncallback"); 
		JSONArray r = null;
		
		PrintWriter out=resp.getWriter();
		String ret = "undefined";
		try {
			String type = req.getParameter("type");
			String original = req.getParameter("q");
			if(StringUtils.isBlank(original)){
				throw new Exception("key word can't be empty!");
			}
			String finalString = original.trim();
//			String method = req.getMethod();
			// 需要兼容get,post请求的编码
//			if("post".equalsIgnoreCase(method)) {
			if(ResponseUtil.isMessyCode(finalString)) {
				finalString = new String(finalString.getBytes("ISO-8859-1"), "utf-8");
			}
			
			String queryWord = URLDecoder.decode(finalString, "utf-8");
			if("evilcode".equalsIgnoreCase(queryWord)) {
				queryWord = "qingersm";
			}
			String q=URLEncoder.encode(queryWord, "utf-8");; // 查询数据
			
//			String consoleInfo = new Date().toLocaleString() + " $" + type + "$ , Query Word: ##" + queryWord + "##, ip: " + ResponseUtil.getIpAddress(req);
//			System.out.println("Console: " + consoleInfo);
			
			String logInfo = " $" + type + "$ , Query Word: ##" + queryWord + "##, ip: " + ResponseUtil.getIpAddress(req);
			ResponseUtil.log.info(logInfo);
			
			String start=req.getParameter("start"); // 起始页
			String urlStr ="https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=10&hl=zh_CN&prettyPrint=false&source=gcsc&gss=.com&sig=8bdfc79787aa2b2b1ac464140255872c&start="+start+"&cx=014581366121687027595:2xkbufxxeua&q="+q+"&sort=&googlehost=www.google.com";
			if("newsmth".equals(type)) {
				urlStr = "https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=10&hl=zh_CN&prettyPrint=false&source=gcsc&gss=.com&sig=8bdfc79787aa2b2b1ac464140255872c&start="+start+"&cx=014581366121687027595:impy7hjb794&q="+q+"&sort=&googlehost=www.google.com";
			}
			
			
			URL url = new URL(urlStr); 
		    BufferedReader bufr = new BufferedReader(new InputStreamReader(new BufferedInputStream(url.openStream()),"utf-8"));
		    String line;
		    
		    while((line = bufr.readLine())!=null){
		    	sb.append(line);
		    }
		    bufr.close();
		    JSONObject jsonObject=JSONObject.fromObject(sb.toString());
		    JSONArray results=jsonObject.getJSONArray("results");
		    r = new JSONArray();
		    for(int i=0;i<results.size();i++){
		    	JSONObject j=(JSONObject) results.get(i);
		    	JSONObject o=new JSONObject();
		    	o.put("title", j.get("title"));
		    	o.put("content", j.get("content"));
		    	o.put("unescapedUrl", j.get("unescapedUrl"));
		    	r.add(o);
		    }
		    ret = r.toString();
		} catch (ConnectException ce) {
			// 网络链接失败
			System.out.println("goResponse: " + sb);
			ce.printStackTrace();
		} catch (Exception e) {
			System.out.println("goResponse: " + sb);
			e.printStackTrace();
		} finally {
			// 兼容跨域访问
			if(StringUtils.isNotBlank(jsoncallback)) {
				out.println(jsoncallback+"(" + ret + ")");
			} else {
				out.println(ret);
			}
			
			out.flush();
			out.close();
		}
		
		
	}
	
	

}
