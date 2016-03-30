<%@ page import="entity.MovieComment" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/26/15
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>See reply</h1>


<table border="1" cellspacing="1" cellpadding="1" align="center">
    <tr>
        <td>
            People who reply
        </td>
        <td>
            Reply time
        </td>
        <td>
            Reply content
        </td>
    </tr>


    <%--<div class="chatMain">--%>
    <%--<ul class="ulSet">--%>
    <%--<li class="li1">People who reply</li>--%>
    <%--<li class="li1">Reply time</li>--%>
    <%--<li class="li3" style="width:800px">Reply content</li>--%>
    <%--</ul>--%>
    <%--</div>--%>

    <%
        List<MovieComment> commentList = (List<MovieComment>) request.getAttribute("movieCommentList");
//        for(MovieComment c:commentList){
        for (int i = 0; i < commentList.size(); i++) {
            MovieComment c = commentList.get(i);

    %>
    <tr>
        <td>
            <%=c.getUserid() %>
        </td>
        <td>
            <%=c.getCommenttime() %>
        </td>
        <td>
            <%=c.getCommenttext() %>
        </td>
    </tr>
    <%--<ul class="ulSet">--%>
        <%--<li class="li1"><%=c.getUserid() %>--%>
        <%--</li>--%>
        <%--<li class="li1"><%=c.getCommenttime() %>--%>
        <%--</li>--%>
        <%--<li class="li3" style="width:800px"><%=c.getCommenttext() %>--%>
        <%--</li>--%>
    <%--</ul>--%>

    <%
        }
    %>
</table>

<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
