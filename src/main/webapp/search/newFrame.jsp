<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html itemscope="" itemtype="http://schema.org/SearchResultsPage" lang="en">
<head>
    <link href="/images/Globe_earth_search.ico" rel="shortcut icon">
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <title><%=request.getAttribute("qWord")%> - 墙洞搜索</title>
    <link href="/css/base2.css" rel="stylesheet" type="text/css"/>
    <link href="/css/newFrame.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
    <script src="/js/search2.js"></script>
</head>
<body class="hsrp" bgcolor="#ffffff" marginheight="0" marginwidth="0" topmargin="0">
<div class=gbh style=left:0></div>
<div class=gbh style=right:0></div>
<table id="mn" border="0" cellpadding="0" cellspacing="0" style="position:relative">
    <tr>
        <th width="132"></th>
        <th width="573"></th>
        <th width="278"></th>
        <th></th>
    </tr>
    <tr>
        <td class="sfbgg" valign="top">
            <div id="logocont"><h1><a href="/search/">Double Google</a></h1></div>
        </td>
        <td class="sfbgg" colspan="2" valign="top" style="padding-left:0px">
            <form action="/search" id="cse-search-box" method="GET" name="f"
                  style="display:block;margin:0;background:none">
                <table border="0" cellpadding="0" cellspacing="0" style="margin-top:20px;position:relative">
                    <tr>
                        <td>
                            <div class="lst-a">
                                <table cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="lst-td" width="555" valign="bottom">
                                            <div id="sugOut" style="position:relative;zoom:1"><input class="lst"
                                                                                                     autocomplete="off"
                                                                                                     id="q"
                                                                                                     maxlength="2048"
                                                                                                     name="q"
                                                                                                     type="text"
                                                                                                     value="<%=request.getAttribute("qWord")%>">
                                                <div id="sug"></div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                        <td>
                            <div class="ds">
                                <div class="lsbb">
                                    <button class="lsb" value="Search" name="btnG" type="submit">墙洞搜索</button>
                                </div>
                            </div>
                        </td>
                        <td><input type="checkbox" style="margin-left:15px; display:none;" id="agent-cb"
                                   name="agent-cb"></td>
                    </tr>
                </table>
                <input name="newwindow" value="1" type="hidden">
                <input type="hidden" name="lr" value="lang_zh-CN">
            </form>
        </td>
        <td class="sfbgg">&nbsp;</td>
    </tr>
    <tbody data-jibp="h" data-jiis="uc" id="desktop-search">
    <tr>
        <td id="leftnav" valign="top">
            <div><h2 class="hd">Search Options</h2>
                <ul class="med" id="tbd"></ul>
            </div>
        </td>
        <td valign="top">
            <div id="center_col">
                <div class="sd" id="resultStats">&nbsp;</div>
                <%=request.getAttribute("resultList")%>
            </div>
            <div id="foot">
                <%=request.getAttribute("pageIndex")%>
                <div class="_cD" id="fll" style="margin:19px auto 19px auto;text-align:center">
                    <p align="center" style="color:#1a0dab !important;">
                        免责声明：本站只提供信息检索服务, 不存储任何内容。<br />
                        如果有侵犯之处，及时联系我们整改。联系:qings2329@sina.com<br />
                        Copyright&copy;2016-2018  墙洞搜索引擎<br />
                    </p>
                </div>
            </div>
        </td>
    </tr>

    </tbody>
</table>
</body>
</html>
<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="/js/bcommon.js"></script>
