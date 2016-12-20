<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade Query</title>
</head>
<body>
<form action="Login" method="post">
    <input type="hidden" value="login" name="flag"/>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" id="username" name="username"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" id="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan=2><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
总人数：
<%
    ServletContext context = session.getServletContext();
    Integer count = (Integer) context.getAttribute("all_count");
%>
<%=count %>
已登录：
<%
    Integer count1 = (Integer) context.getAttribute("user_count");
    if (count1 == null)
        count1 = 0;
%>
<%=count1 %>
</body>
</html>
