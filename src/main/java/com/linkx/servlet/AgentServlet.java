package com.linkx.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import com.linkx.util.HttpUtils;


public class AgentServlet extends HttpServlet {

	private static final long serialVersionUID = 2210804022569079202L;


  /**
   * @see HttpServlet#HttpServlet()
   */
  public AgentServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
	  this.doPost(request, response);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		if(true){
//			throw new ServletException("测试前端处理异常的逻辑");
//		}
	  
	    // 在设置resp编码之前, 就调用resp.getWriter(), 会出现乱码. 因为getWriter()里面需要用到编码
//	    PrintWriter printWriter = resp.getWriter();
		String ret = "";
		try {
			resp.setContentType("text/html;charset=utf-8");
			resp.setCharacterEncoding("UTF-8");
			
			
		    String targetUrl = req.getParameter("targetUrl");
		    ret = HttpUtils.request(targetUrl, "GET", null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			

		    PrintWriter printWriter = resp.getWriter();
			printWriter.println(ret);
			printWriter.flush();
			printWriter.close();
			
//			OutputStream outputStream = resp.getOutputStream(); 
//			outputStream.write(ret.getBytes("UTF-8"));
//			outputStream.flush();
//			outputStream.close();
		}
  }
  
  
  /**
   * 测试
   * @param args
   */
  public static void main(String args[]) {
//	  String url = "https://forums.godfootsteps.org/topic/10616-%E6%9B%B4%E5%8A%A0%E5%AE%89%E5%85%A8%E7%9A%84%E7%BF%BB%E";
//	  System.out.println(URLDecoder.decode(url));
	  
	  String test = null;
	  String testString1 = "java html 转义";
	  String testString2 = "HTTP-EQUIV=\"Pragma\"";
	  test = StringEscapeUtils.escapeHtml4(testString1);
	  System.out.println(test);
  }


}