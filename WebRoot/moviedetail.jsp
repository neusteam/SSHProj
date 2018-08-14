<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'moviedetail.jsp' starting page</title>
    

  </head>
  
  <body>
    电影名： ${moviename}<br>
    导演：<s:iterator value="#request.dc" status="st">
<s:iterator value="#request.dc[#st.index]">
<a href="selectactor?actorInfo.director=<s:property/>"><s:property/></a>
</s:iterator>/
</s:iterator><br>
    主演：<s:iterator value="#request.ac" status="st">
<s:iterator value="#request.ac[#st.index]">
<a href="selectactor?actorInfo.actorname=<s:property/>"><s:property/></a>
</s:iterator>/
</s:iterator><br>
    类型： ${type}<br>
    制片国家： ${country}<br>
    语言： ${language}<br>
   上映日期： ${date}<br>
   豆瓣评分： ${score}<br>
   剧情简介： ${describe}<br>
 
 　<img alt="" src="${picture}">
  </body>
</html>
