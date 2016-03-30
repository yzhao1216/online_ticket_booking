<%@ page import="entity.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Movie" %>
<%@ page import="entity.MovieInfo" %>

<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/24/15
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <h1>
        Movie Manage
    </h1>
    <table class="table" border="1">
        <tr class="table_header">
            <td>
                ID:
            </td>
            <td>
                Title:
            </td>
            <td>
                Time:
            </td>
            <td>
                Price:
            </td>
            <td>
                Director:
            </td>
            <td>
                Description:
            </td>
            <td>
                Action:
            </td>

        </tr>
        <%

            List<MovieInfo> movies =
                    (List<MovieInfo>) request.getAttribute("movies");
            for (int i = 0; i < movies.size(); i++) {
                MovieInfo m = movies.get(i);
        %>
        <tr class="row<%=(i % 2 + 1) %>">
            <td>
                <%=m.getId()%>
            </td>
            <td>
                <%=m.getTitle()%>
            </td>
            <td>
                <%=m.getTime()%>
            </td>
            <td>
                <%=m.getPrice()%>
            </td>
            <td>
                <%=m.getDirector()%>
            </td>
            <td>
                <%=m.getDescription()%>
            </td>
            <td>
                <%--<a href="managerloadmovie.do?id=<%=m.getId()%>">Modify</a>--%>
                <form action="managerloadmovie.do" method="post">
                    <input type="hidden" name="movieid" value="<%=m.getId()%>">
                    <input type="hidden" name="mname" value="<%=request.getAttribute("mname")%>">
                    <input type="submit" name="modify" value="modify">
                </form>
                <%--<a href="delmovie.do?id=<%=m.getId()%>">Delete</a>--%>
            </td>


        </tr>
        <%
            }
        %>
    </table>


</div>
<form action="list.do" method="post">
    <input type="submit" value="Update worker">
</form>


<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
