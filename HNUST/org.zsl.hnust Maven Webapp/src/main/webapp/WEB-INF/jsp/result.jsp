<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="zh-CN">
<head>

    <base href="<%=basePath%>">


  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <title>上传图片</title>
  
	<link rel="stylesheet" type="text/css" href="<c:url value="/Static/css/easyui.css"/>">
<script type="text/javascript" src="<c:url value="/Static/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/Static/js/jquery.easyui.min.js"/>"></script>


<link rel="stylesheet" href="<c:url value="/Static/flowcss/style.css"/>">
<link href="<c:url value="/Static/css/style.css"/>" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/Static/js/menu.js"/>"></script>
<script type="text/javascript" src="<c:url value="/Static/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/Static/js/main.js"/>"></script>

<script type="text/javascript">
    function refresh() {
        //IE存在缓存,需要new Date()实现更换路径的作用
         document.getElementById("image").src="/HNUST/user/image?"+new Date();
    }  
</script>
</head>

<body>
<div id="pgcontainer">
  <header>
    <div id="navbar">
      <a  class="menubtn">menu</a>
      <p>公司</p>
      <!-- use captain icon for toggle menu -->
      <div id="hamburgermenu">

        <div>
    	    <div><img src="<c:url value="/Static/img/psb.png"/>" width="20px" height="20px"/></div>
    	    <div><span>欢迎你</span></div>
          <div>  <span><%=session.getAttribute("userName") %>（公司）</span></div>
            </div>

        <ul>
          <li><a href="/HNUST/user/index">功能菜单</a></li>
          <li><a href="/HNUST/user/index">流向查询</a></li>
          <li><a href="/HNUST/user/upload">上传</a></li>
          <li><a href="/HNUST/user/password">密码修改</a></li>
          <li><a href="/HNUST/user/exit">退出</a></li>
        </ul>
      </div>
    </div>
    <div class="overlay"></div>
  </header>

  <div id="content">
    
        <img alt="" src="${fileUrl }" />  
        
    </div>
</div><!-- @end #pgcontainer -->
</body>
</html>
