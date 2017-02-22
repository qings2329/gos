package com.linkx.servlet;

import com.linkx.util.HttpUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.util.NodeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
    String ret = "<html><body>Sorry, Something Wrong Happens !</body></html>";
    String uri = request.getRequestURI();
    try {

      // 暂时不启用代理功能
      //            String agent = request.getParameter("agent-cb");
      //            if("on".equals(agent)) {
      //                agent = " checked=\"true\" ";
      //            } else {
      //                agent = "";
      //            }

      String params = request.getQueryString();

      if (params == null) {
        response.sendRedirect("/search/");
        return;
      } else {
        params = "?gws_rd=cr&newwindow=1&" + params;
      }

      ret = HttpUtils.request(googleSearch + uri + params, "GET", null);

      //            ret = TEST_HTML;

      if (ret == null) {
        response.sendRedirect("/search/");
        return;
      }

      if ("/search".equals(uri)) {
        // 处理搜索结果
        Parser parser = new Parser(ret);
        NodeFilter divNodeFilter = new TagNameFilter("div");
        NodeFilter attrNodeFilter = new HasAttributeFilter("id", "search");
        NodeFilter filter = new AndFilter(divNodeFilter, attrNodeFilter);

        NodeList nodes = parser.extractAllNodesThatMatch(filter);
        String resultList = "";
        if (nodes != null) {
          //				resultList = nodes.toHtml().replace("/url?q=", "");
          //                resultList = resultList.replace("&amp;sa=", "?sa=");
          resultList = nodes.toHtml();
        }
        request.setAttribute("resultList", resultList);

        NodeFilter divNodeFilter2 = new TagNameFilter("div");
        NodeFilter attrNodeFilter2 = new HasAttributeFilter("id", "foot");
        NodeFilter filter2 = new AndFilter(divNodeFilter2, attrNodeFilter2);
        parser.reset();
        String pageIndex = "";

        NodeList footNodes = parser.extractAllNodesThatMatch(filter2);
        if (footNodes != null && footNodes.size() > 0) {
          //NodeList tableNode = footNodes.extractAllNodesThatMatch(new TagNameFilter("table"));
          Node tableNode = footNodes.elementAt(0).getFirstChild();

          if (tableNode != null) {
            pageIndex = tableNode.toHtml();
          }
        }
        request.setAttribute("pageIndex", pageIndex);

        NodeFilter divNodeFilter3 = new TagNameFilter("input");
        NodeFilter attrNodeFilter3 = new HasAttributeFilter("id", "sbhost");
        NodeFilter filter3 = new AndFilter(divNodeFilter3, attrNodeFilter3);
        parser.reset();
        NodeList inputNodeList = parser.extractAllNodesThatMatch(filter3);
        String qWord = "";
        if (inputNodeList != null && inputNodeList.size() > 0) {
          qWord = ((InputTag) inputNodeList.elementAt(0)).getAttribute("value");
        }
        request.setAttribute("qWord", qWord);

      }

    } catch (Exception ex) {
      ret = ex.toString();
      ex.printStackTrace();
    }

    response.setContentType("text/html;charset=utf-8");
    if ("/search".equals(uri)) {
      ServletContext servletContext = getServletContext();
      RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/search/newFrame.jsp");
      requestDispatcher.forward(request, response);
    } else {
      response.getWriter().append(ret).append(request.getContextPath());
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }


}