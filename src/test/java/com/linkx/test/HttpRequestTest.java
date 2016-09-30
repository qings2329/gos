package com.linkx.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.linkx.util.HttpUtils;

/**
 * @author qings2329
 *
 * @since Sep 15, 2016   11:17:38 PM
 */
public class HttpRequestTest {
	
	private Logger logger = Logger.getLogger(getClass());
	
	String goUrl = "https://www.google.com/search?gws_rd=cr&q=%E6%B5%8B%E8%AF%95&newwindow=1&biw=665&bih=617&ei=XrLaV82SI8aGjwPoyq2oBQ&start=40&sa=N";

	@Test
	public void test_go_search() throws Exception {
		
		String ret = HttpUtils.request(goUrl, "get", null);
		
		logger.info(ret);
		
	}
	
	
}
