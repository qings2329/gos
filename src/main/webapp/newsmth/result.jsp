<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String query = request.getParameter("q") == null ? "" : request.getParameter("q").trim();
	String method = request.getMethod();
	if("post".equalsIgnoreCase(method)) {
		query = new String(query.getBytes("ISO-8859-1"), "utf-8");
	}
%>	
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/images/search.ico" rel="shortcut icon">
<title>水榴搜索</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="水榴搜索|欧洲杯|奥运会" />
<meta name="description" content="水榴搜索，社区资源" />
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link href="http://www.java1234.com/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="http://www.java1234.com/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="http://www.java1234.com/bootstrap/js/jQuery.js"></script>
<script src="http://www.java1234.com/bootstrap/js/bootstrap.js"></script>
<link href="/css/base2.css" rel="stylesheet" type="text/css" />


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
		$.post("/doSearch",{type:"newsmth",q:q,start:start},function(result){
		//$.getJSON("/doSearch?jsoncallback=?",{type:"newsmth",q:q,start:start},function(result){
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
		},"json");
	}
	
	$(function(){
		
		// 不放在$(function(){})里面执行会出问题, document.getElementById用不了
		if(checkForm()) {
			loadData("<%=query%>",0);
		}
	});
</script>


<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?84ad75531a92ba8433ad6e9013c8bade";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

</head>
<body >
<div align="center" style="padding-top: 10px;">

<div style="text-align:center">
	<a href="http://link-x.ml/newsmth/" style="color:red; font-size:20px; text-decoration: underline;">重要通知: 网站迁移至 http://link-x.ml/newsmth/ 。 点击跳转 ！ </a>
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
					<form id="cse-search-box" name=f action="result.jsp" method="post" onsubmit="return checkForm()">

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
					<button type="submit">水榴一下</button>
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
			         <div id="cse2"><div id="loading" style="text-align:center; font-size:15px; width:auto; height:60px; width:100%;"><img src="/images/loading.gif" alt="电影"/> 正在加载数据，请稍后....请不要离开...</div></div>
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
				Copyright&copy;2016-2017  水榴搜索引擎<br />
			</p>
			
		</td>
	</tr>
</table>
</div>

<script type="text/javascript" src="/js/base.js"></script>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>


</body>
</html>

