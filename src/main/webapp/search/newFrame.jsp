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
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
    <script src="/js/search2.js"></script>
    <style>.gbh, .gbd {
        border-top: 1px solid #c9d7f1;
        font-size: 1px
    }

    .gbh {
        height: 0;
        position: absolute;
        top: 24px;
        width: 100%
    }

    .star {
        float: left;
        margin-top: 1px;
        overflow: hidden
    }

    body, td, div, .p, a {
        font-family: arial, sans-serif;
        tap-highlight-color: rgba(255, 255, 255, 0)
    }

    body {
        margin: 0
    }

    a img {
        border: 0
    }

    a.gl {
        text-decoration: none
    }

    ._Umd a:link {
        color: #0E1CB3
    }

    #foot {
        padding: 0 8px
    }

    #foot a {
        white-space: nowrap
    }

    h3 {
        font-size: 16px;
        font-weight: normal;
        margin: 0;
        padding: 0
    }

    #res h3 {
        display: inline
    }

    .hd {
        height: 1px;
        position: absolute;
        top: -1000em
    }

    .g, body, html, table, .std {
        font-size: 13px
    }

    .g {
        margin-bottom: 23px;
        margin-top: 0;
        zoom: 1
    }

    ol li, ul li {
        list-style: none
    }

    h1, ol, ul, li {
        margin: 0;
        padding: 0
    }

    #mbEnd h2 {
        font-weight: normal
    }

    #leftnav a {
        text-decoration: none
    }

    #leftnav h2 {
        color: #767676;
        font-weight: normal;
        margin: 0
    }

    #nav {
        border-collapse: collapse;
        margin-top: 17px;
        text-align: left
    }

    #nav td {
        text-align: center
    }

    .nobr {
        white-space: nowrap
    }

    .ts {
        border-collapse: collapse
    }

    .s br {
        display: none
    }

    .csb {
        display: block;
        height: 40px
    }

    .images_table td {
        line-height: 17px;
        padding-bottom: 16px
    }

    .images_table img {
        border: 1px solid #ccc;
        padding: 1px
    }

    #tbd, #abd {
        display: block;
        min-height: 1px
    }

    #tbd li {
        display: inline
    }

    #tbd.tbt li {
        display: block;
        font-size: 13px;
        line-height: 1.2;
        padding-bottom: 3px;
        padding-left: 8px;
        text-indent: -8px
    }

    .tbos, .b {
        font-weight: bold
    }

    em {
        font-weight: bold;
        font-style: normal
    }

    .soc a {
        text-decoration: none
    }

    ._AC a {
        text-decoration: none
    }

    .gssb_c table {
        font-size: 16px !important
    }

    #res {
        padding: 0 8px
    }

    #topstuff.e {
        padding-bottom: 6px
    }

    .ac, .st {
        line-height: 1.24
    }

    .st b {
        color: #dd4b39
    }

    .s {
        color: #545454
    }

    a.fl, ._cD a, .osl a {
        color: #1a0dab;
        text-decoration: none
    }

    a:link {
        color: #1a0dab;
        cursor: pointer
    }

    #tads a:link {
        color: #1a0dab
    }

    #tads.soc a:link {
        color: #808080
    }

    #tads._AC a:link {
        color: #808080
    }

    ._AC a:link {
        color: #808080
    }

    ._AC a:visited {
        color: #808080
    }

    ._AC a:hover {
        color: #808080;
        text-decoration: underline
    }

    a:visited {
        color: #61C
    }

    .blg a {
        text-decoration: none
    }

    cite, cite a:link {
        color: #006621;
        font-style: normal
    }

    #tads cite {
        color: #006621
    }

    .kv {
        font-size: 15px
    }

    .kv, .kvs, .slp {
        display: block;
        margin-bottom: 1px
    }

    #mbEnd li {
        margin: 20px 8px 0 0
    }

    .f {
        color: #808080
    }

    ._pJb {
        color: #093
    }

    h4.r {
        display: inline;
        font-size: small;
        font-weight: normal
    }

    .g {
        line-height: 1.2
    }

    ._Gnc li {
        list-style-type: disc
    }

    .osl {
        color: #777;
        margin-top: 4px
    }

    .r {
        font-size: 16px;
        margin: 0
    }

    .spell_orig a {
        text-decoration: none
    }

    .spell_orig b i {
        font-style: normal;
        font-weight: normal
    }

    .th {
        border: 1px solid #ebebeb
    }

    .ts td {
        padding: 0
    }

    .slk a {
        text-decoration: none
    }

    #leftnav a:hover, #leftnav.tbou a:hover, .slk h3 a, a:hover {
        text-decoration: underline
    }

    #mn {
        table-layout: fixed;
        width: 100%
    }

    #leftnav a {
        color: #222;
        font-size: 13px
    }

    #leftnav {
        padding: 43px 4px 4px 0
    }

    #tbd {
        padding: 0 0 0 16px
    }

    .tbou a {
        color: #222
    }

    #center_col {
        border: 0;
        padding: 0 8px 0 0
    }

    #topstuff.e {
        padding-top: 3px
    }

    #topstuff.sp_cnt {
        padding-top: 6px
    }

    #resultStats {
        color: #999;
        font-size: 13px;
        overflow: hidden;
        white-space: nowrap
    }

    .mslg > td {
        padding-right: 1px;
        padding-top: 2px
    }

    .slk.sld {
        margin-top: 2px;
        padding: 5px 0 5px 5px
    }

    #fll a, #bfl a {
        color: #1a0dab !important;
        margin: 0 12px;
        text-decoration: none !important
    }

    #mss p {
        margin: 0;
        padding-top: 5px
    }

    a._Jhd:hover {
        color: black;
        text-decoration: none;
        white-space: nowrap
    }

    body {
        margin: 0;
        padding: 0
    }

    .sd {
        line-height: 43px;
        padding: 0 8px 0 9px
    }

    a:active, .osl a:active, .tbou a:active, #leftnav a:active {
        color: #dd4b39
    }

    #_Xud a:active, #bfl a:active {
        color: #dd4b39 !important
    }

    .csb {
        overflow: hidden
    }

    .star div, .star span {
        height: 13px;
        width: 65px;
        display: block
    }

    ._nBb {
        display: inline;
        margin: 0 3px;
        outline-color: transparent;
        overflow: hidden;
        position: relative
    }

    ._nBb > div {
        outline-color: transparent
    }

    ._O0 {
        border-color: transparent;
        border-style: solid dashed dashed;
        border-top-color: green;
        border-width: 4px 4px 0 4px;
        cursor: pointer;
        display: inline-block;
        font-size: 0;
        height: 0;
        left: 4px;
        line-height: 0;
        outline-color: transparent;
        position: relative;
        top: -3px;
        width: 0
    }

    ._O0 {
        margin-top: -4px
    }

    .am-dropdown-menu {
        display: block;
        background: #fff;
        border: 1px solid #dcdcdc;
        font-size: 13px;
        left: 0;
        padding: 0;
        position: absolute;
        right: auto;
        white-space: nowrap;
        z-index: 3
    }

    ._Ykb {
        list-style: none;
        white-space: nowrap
    }

    ._Ykb:hover {
        background-color: #eee
    }

    a._Zkb {
        color: #333;
        cursor: pointer;
        display: block;
        padding: 7px 18px;
        text-decoration: none
    }

    #tads a._Zkb {
        color: #333
    }

    .sfbgg {
        background: #f1f1f1;
        border-bottom: 1px solid #e5e5e5;
        height: 71px
    }

    #logocont {
        z-index: 1;
        padding-left: 4px;
        padding-top: 4px
    }

    #logo {
        display: block;
        height: 49px;
        margin-top: 12px;
        margin-left: 12px;
        overflow: hidden;
        position: relative;
        width: 137px
    }

    #logo img {
        left: 0;
        position: absolute;
        top: -41px
    }

    .lst-a {
        background: white;
        border: 1px solid #d9d9d9;
        border-top-color: silver;
        width: 570px
    }

    .lst-a:hover {
        border: 1px solid #b9b9b9;
        border-top: 1px solid #a0a0a0;
        box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
        -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
        -moz-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1)
    }

    .lst-td {
        border: none;
        padding: 0
    }

    .tia input {
        border-right: none;
        padding-right: 0
    }

    .lst {
        border: none;
        color: #000;
        font: 16px arial, sans-serif;
        float: left;
        height: 22px;
        margin: 0;
        padding: 3px 6px 2px 9px;
        vertical-align: top;
        width: 100%;
        word-break: break-all
    }

    .lst:focus {
        outline: none
    }

    .ds {
        border-right: 1px solid #e7e7e7;
        position: relative;
        height: 29px;
        margin-left: 17px;
        z-index: 100
    }

    .lsbb {
        background-image: -moz-linear-gradient(top, #4d90fe, #4787ed);
        background-image: -ms-linear-gradient(top, #4d90fe, #4787ed);
        background-image: -o-linear-gradient(top, #4d90fe, #4787ed);
        background-image: -webkit-gradient(linear, left top, left bottom, from(#4d90fe), to(#4787ed));
        background-image: -webkit-linear-gradient(top, #4d90fe, #4787ed);
        background-image: linear-gradient(top, #4d90fe, #4787ed);
        border: 1px solid #3079ed;
        border-radius: 2px;
        background-color: #4d90fe;
        height: 27px;
        width: 80px
    }

    .lsbb:hover {
        background-image: -moz-linear-gradient(top, #4d90fe, #357ae8);
        background-image: -ms-linear-gradient(top, #4d90fe, #357ae8);
        background-image: -o-linear-gradient(top, #4d90fe, #357ae8);
        background-image: -webkit-gradient(linear, left top, left bottom, from(#4d90fe), to(#357ae8));
        background-image: -webkit-linear-gradient(top, #4d90fe, #357ae8);
        background-color: #357ae8;
        background-image: linear-gradient(top, #4d90fe, #357ae8);
        border: 1px solid #2f5bb7
    }

    .lsb {
        background: transparent;
        background-position: 0 -343px;
        background-repeat: repeat-x;
        border: none;
        color: #000;
        cursor: default;
        font: 15px arial, sans-serif;
        height: 29px;
        margin: 0;
        vertical-align: top;
        width: 100%
    }

    .lsb:active {
        -moz-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.3);
        box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.3);
        background: transparent;
        color: transparent;
        overflow: hidden;
        position: relative;
        width: 100%
    }</style>
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
                <input name="newwindow" value="1" type="hidden"></form>
        </td>
        <td class="sfbgg">&nbsp;</td>
    </tr>
    <tbody data-jibp="h" data-jiis="uc" id="desktop-search">
    <style>._Bu, ._Bu a:link, ._Bu a:visited, a._Bu:link, a._Bu:visited {
        color: #808080
    }

    ._Azf a {
        color: #777;
        text-decoration: none
    }</style>
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
                        Copyright&copy;2017-2018  墙洞搜索引擎<br />
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
<script>window._bd_share_config = {
    "common": {
        "bdSnsKey": {},
        "bdText": "",
        "bdMini": "2",
        "bdMiniList": false,
        "bdPic": "",
        "bdStyle": "0",
        "bdSize": "16"
    },
    "slide": {"type": "slide", "bdImg": "2", "bdPos": "right", "bdTop": "100"},
    "image": {"viewList": ["qzone", "tsina", "tqq", "renren", "weixin"], "viewText": "分享到：", "viewSize": "16"},
    "selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"]}
};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "//hm.baidu.com/hm.js?84ad75531a92ba8433ad6e9013c8bade";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s)
})();</script>


<iframe style="margin-top: 30px; display:none;" sframeborder="0" width="100%" scrolling="no" src="http://bitkan.com/news/topic/29461?bkuserid=28406&bkfrom=appshare&bktarget=weixin&from=groupmessage&isappinstalled=1">

</iframe>