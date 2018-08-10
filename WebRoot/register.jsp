<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    


  </head>
  
  <body>
    ${msg}
  <form action="regist">
   账号:<input name="user.username"  type="text"><br>
   密码:<input name="user.password"  type="password"><br>
  <input type="submit"  value="注册">
   </form>
   <a href="findAll">查所有用户</a>
   <a href="findAllMovie">查所有电影</a>
  </body>
</html>
