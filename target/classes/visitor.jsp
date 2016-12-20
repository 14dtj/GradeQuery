<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游客</title>
</head>
<body>
已登录人数：
<%
    ServletContext context = session.getServletContext();
    Integer count = (Integer) context.getAttribute("user_count");
%>
<%=count %>
<br/>
<a href="index.html">登录</a>
</body>
</html>
