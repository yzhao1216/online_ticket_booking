<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/26/15
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Thread</title>
</head>
<body>
<h1>Post Thread</h1>
<div align="center">
    <%
        String userid = request.getParameter("uid");
    %>
    <form action="postThread.do" method="post">
        Please input Movie ID <input type="text"  name="id"><br>
        Input your rating <input type="text" name="rate"><br>
        Input content<textarea id="input" rows="4" name="textarea"></textarea>
        <input type="hidden" value="<%=userid%>" name="uid">
        <input type="submit" value="submit">
    </form>
</div>
<div align="center">
    <form action="threadList.jsp" method="post">
        <input type="submit" value="Show Message">
        <input type="hidden" value="<%=userid%>" name="userid">
    </form>

    <%--<a href="threadList.jsp">Show my message</a>--%>
</div>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
