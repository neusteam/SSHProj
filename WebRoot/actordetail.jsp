<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	
  </head>
  
  <body>
  姓名:${actorname}<br>
  性别:${sex}<br>
  出生日期:${birth}<br>
  出生地:${hometown}<br>
  职业:${occupation}<br>
  影人简介:${describe} <br>
  <img alt="" src="${picture}">
  </body>
</html>
