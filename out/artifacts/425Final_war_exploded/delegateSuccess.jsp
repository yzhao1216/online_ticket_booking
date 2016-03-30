<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 12/1/15
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>
    delegateSuccess
</h1>
<%=request.getAttribute("name")%> has been delegated, now he can update the movie information
<a href="http://localhost:8080/index.jsp">Go back</a>
</body>
</html>
