<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.linkx.util.ResponseUtil" %>	
<%
	String query = request.getParameter("q") == null ? "" : request.getParameter("q").trim();
	String method = request.getMethod();
	if(ResponseUtil.isMessyCode(query) || "post".equalsIgnoreCase(method)) {
		query = new String(query.getBytes("ISO-8859-1"), "utf-8");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<div id='wx_pic' style='margin:0 auto;display:none;'>
	  <img src='images/car.jpg' alt="黑丝"/>
	</div>
<title>百度网盘搜索引擎</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="百度网盘搜索|网盘搜索|百度云搜索" />
<meta name="description" content="百度网盘搜索，搜索百度网盘资源" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link href="http://ajax.aspnetcdn.com/ajax/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<link href="css/base2.css" rel="stylesheet" type="text/css" />


<style>
	b{
		color: red;
	}
</style>
<script type="text/javascript">
	function checkForm(){
		var q=document.getElementById("q");
		if(q.value==null || q.value==""){
			alert("请输入需要搜索的信息！");
			return false;
		}
		return true;
	}
	
	function loadData(q,start){
		
		
		$.post("/doSearch",{type:"bdpan",q:q,start:start},function(result){
		//$.getJSON("/doSearch?jsoncallback=?",{type:"bdpan",q:q,start:start},function(result){
		//$.getJSON("http://www.pan1234.com/server?jsoncallback=?",{q:q,start:start},function(result){
			
			if(typeof(result) == "undefined") {
				alert("网络繁忙, 请稍后再试!");
				return;
			}
			
			if(result.length==0){
				alert("未搜索到结果，请换个关键字！");
			}else{
				$("#result").children().remove();
				$("#result").append("<font>搜索结果：</font><hr style='margin-top: 2px; margin-bottom: 10px;'></hr>");
				$.each(result,function(i,val){
					var di=$("<p>"+"<a style='font-size:16px;color:#1f4fcd;text-decoration:underline;' href='"+val.unescapedUrl+"' target='_blank'>"+val.title+"</a></br>"+
							  "<span style='font-size:14px'>"+val.content+"</span></br>"+
							  "<span style='color:green;font-size:13px'>"+val.unescapedUrl.substring(0, 100) +"...</span>"+
							"</p><br/>");
					$("#result").append(di);
					$("#cse2").remove();
					$("#pa").show();
				});
				
			}
		},"json").error(function(){
			// 后台抛异常, 或者返回的不是json格式的数据, 都会调用此方法
			alert("发生错误, 请稍后重试, 或者通知作者解决!");
		});

		
	}
		
		
	$(function(){
		
		// 不放在$(function(){})里面执行会出问题, document.getElementById用不了
		if(checkForm()) {
			loadData("<%=query%>",0);
		}
	});

</script>


</head>
<body >
<div align="center" style="padding-top: 10px;">

<div style="text-align:center">
	<a href="javascript:void(0)" style="color:red; font-size:15px;">Tips: 关键词不宜过长 </a>
</div>

<table width="960px" align="center"   cellpadding="5px">
	<tr>
		<td colspan="2">
		<div class="nav center">
		<div class="box_outer">
		<div class="box_body">
		<table class="sch" >
			<tbody>
				<tr id='test'>
					<td class="first_td">
						<a href="index.html" ><img src="images/logo2.png" alt="电影"/></a>
					</td>
					<form id="cse-search-box" name="f" action="result.jsp" method="post" onsubmit="return checkForm()">

					<td width="373px" style="padding-bottom: 12px; padding-left: 10px;">
					<br/>
					<input type="hidden" name="wp" id="wp" value="0" />
				    <input type="hidden" name="op" id="op" value="0" />
				    <input type="hidden" name="ty" id="ty" value="gn" />
					<div id="sugOut"><input   id="q" name="q"  value="<%=query%>"  maxlength=100
						 autocomplete="off">
						<br>
					<div id="sug"></div>
					</div>
					</td>
					<td style="padding-bottom: 12px; ">
					<br/>
					<button type="submit">网盘一下</button>
					</td>
					</form>
					<td align=right id="hao_search_content" width="360px"></td>
					<td class="last_td"></td>
				</tr>
			</tbody>
		</table>
		</div>
		<div class="box_b"><span class="box_p"></span></div>
		</div>
		</div>
		</td>
	</tr>
	<tr>
		<td width="1000px">
			<div id="search_result">
			         <div id="cse2"><div id="loading" style="text-align:center; font-size:15px; width:auto; height:60px; width:100%;"><img src="images/loading.gif" alt="电影" /> 正在加载数据，请稍后....请不要离开...</div></div>
				     <div id="result">
				     	
				     </div>
				     <div id="pa" class="pagination" style="display: none;">
						  <ul >
						    <li><a href="javascript:loadData('<%=query%>',0)">第1页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',10)">第2页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',20)">第3页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',30)">第4页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',40)">第5页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',50)">第6页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',60)">第7页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',70)">第8页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',80)">第9页</a></li>
						    <li><a href="javascript:loadData('<%=query%>',90)">第10页</a></li>
						  </ul>
					</div>
			    </div>
		</td>
		<td width="260px" valign="top">
			
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<p align="center" style="padding-top: 10px;">
				免责声明：本站只提供信息检索服务, 不存储任何内容。<br />
				如果有侵犯之处，及时联系我们整改。联系:qings2329@sina.com<br />
				Copyright&copy;2016-2017  百度网盘资源搜索引擎<br />
			</p>
			
		</td>
	</tr>
</table>
</div>

<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="/js/bcommon.js"></script>


</body>
</html>
