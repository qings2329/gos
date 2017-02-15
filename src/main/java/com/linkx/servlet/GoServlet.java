package com.linkx.servlet;

import com.linkx.util.HttpUtils;
import com.linkx.util.ResponseUtil;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoServlet
 */
public class GoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String googleSearch = "https://www.google.com";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ret = "<html><body>test</body></html>";
		try{
//			String original = request.getParameter("q");
//			if(StringUtils.isBlank(original)){
//				throw new Exception("key word can't be empty!");
//			}
//			String finalString = original.trim();
//			if(ResponseUtil.isMessyCode(finalString)) {
//				finalString = new String(finalString.getBytes("ISO-8859-1"), "utf-8");
//			}
//			String q = URLEncoder.encode(finalString, "utf-8");

			String uri = request.getRequestURI();
			String params = request.getQueryString();

			if(params == null) {
				params = "?gws_rd=cr&newwindow=1";
			} else {
				params = "?gws_rd=cr&newwindow=1&" + params;
			}

			ret = HttpUtils.request(googleSearch + uri + params, "GET", null);

		} catch (Exception ex) {
			ret = ex.toString();
		} finally {

		}
		response.setContentType("text/html");
		response.getWriter().append(ret).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
