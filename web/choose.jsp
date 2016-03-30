<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/30/15
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="postThread.jsp" method="post">
    <input type="submit" value="Movie Thread">
    <input type="hidden" name="uid" value="<%=request.getAttribute("uid")%>" >
</form>

<%--<form action="postTheatreThread.jsp" method="post">--%>
    <%--<input type="submit" value="Thread Thread">--%>
    <%--<input type="hidden" name="uid" value="<%=request.getAttribute("uid")%>" >--%>
<%--</form>--%>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
