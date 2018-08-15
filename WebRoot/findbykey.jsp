<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.ycj.entity.Movieinfo" %>
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
    <%
   
    ArrayList<Movieinfo> list = (ArrayList)request.getAttribute("list");
    for(int i=0;i<list.size();i++){
    
    %>
    <%=list.get(i).getMoviename() %>/
    <%=list.get(i).getDate() %><br>
    <%=list.get(i).getAverage() %><br>
    <%=list.get(i).getCountry() %>/
     <%=list.get(i).getType() %><br>
    <%=list.get(i).getDirector() %>/
    <%=list.get(i).getActor() %><br>
  
    <img alt="" src="<%=list.get(i).getPicture() %>"><br>
    
    <% 
    }
    %>
  </body>
</html>
