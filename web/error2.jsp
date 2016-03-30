<%@ page import="web.ActionServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/14/15
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<h2>
    Not enough balance
</h2>
<a href="http://localhost:8080/guestList.do">click here to reinput your card information</a><br>
Your balance is :${funds}<br>
The ticket price is :${price};

</body>
</html>
