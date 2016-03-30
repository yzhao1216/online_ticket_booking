<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/6/15
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title align="center">Student Calendar and Discussion Plaza</title>
</head>
<body>
<h2 align="center">Welcome come to the App</h2>

<div align="center">
    <form action="${pageContext.request.contextPath}/select.do" method="post">
        Username<input type="text" name="user"><br>
        Password<input type="password" name="password"><br>
        <%--User type<select name="type">--%>
        <%--<option value="1">User</option>--%>
        <%--<option value="Manager">Manager</option>--%>
        <%--<option value="Onwer">Owner</option>--%>
        <%--<option value="Administer">Web Admin</option>--%>
        </select><br>
        <input type="submit" value="login">
    </form>
    <form action="register.jsp" method="post">
        New user?<a href="register.jsp">please register</a>
    </form>
</div>
<div align="center">
    <form action="guestList.do" method="post">
        <br>
        <input type="submit" value="Guest visit">
        </br>
    </form>
</div>

<!-- list enrollment-->
<div align="center">
    <form action="list.do" method="post">
        <input type="submit" value="List the employee information">

    </form>
</div>


</body>
</html>
