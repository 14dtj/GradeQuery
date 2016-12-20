<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! boolean invalid = false; %>
<html>
<head>
    <title>测验情况</title>
</head>
<body>
<h1>测验情况</h1>
<c:forEach items="${grades}" var="grade">
    <li>
        <span>${grade.course}</span>
        <c:set var="gradeVal" scope="request" value="${grade.grade}"/>
        <%
            double x = Double.parseDouble(request.getAttribute("gradeVal").toString());
            if (x == 0) invalid = true;
        %>
        <span>${grade.grade}</span>
    </li>
</c:forEach>
<br>
<%
    if (invalid) {
%>
<span>你有未参加的测验！</span>
<%
    }
%>
<br>
<a href="/Logout">退出系统</a>
</body>
</html>
