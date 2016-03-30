<%@ page import="entity.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Movie" %>
<%@ page import="entity.MovieInfo" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/24/15
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
this is owner page
<h1>
    Member Information
</h1>
<table class="table" border="1">
    <tr class="table_header">
        <td>
            Userid:
        </td>
        <td>
            Name:
        </td>
        <td>
            Phone:
        </td>
        <td>
            Address:
        </td>
        <td>
            Email:
        </td>
        <td>
            Creditpoint:
        </td>
        <td>
            Status:
        </td>
        <td>
            Balance:
        </td>

    </tr>
    <%

        List<MemberInfo> memberInfos =
                (List<MemberInfo>) request.getAttribute("memberInfos");
        for (int i = 0; i < memberInfos.size(); i++) {
            MemberInfo m = memberInfos.get(i);
    %>
    <tr class="row<%=(i % 2 + 1) %>">
        <td>
            <%=m.getId()%>
        </td>
        <td>
            <%=m.getName()%>
        </td>
        <td>
            <%=m.getPhone()%>
        </td>
        <td>
            <%=m.getAddress()%>
        </td>
        <td>
            <%=m.getEmail()%>
        </td>
        <td>
            <%=m.getCreditpoint()%>
        </td>
        <td>
            <%=m.getStatus()%>
        </td>
        <td>
            <%=m.getBalance()%>
        </td>


    </tr>
    <%
        }
    %>
</table>
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
                <a href="loadmovie.do?id=<%=m.getId()%>">Modify</a>
                <%--<a href="delmovie.do?id=<%=m.getId()%>">Delete</a>--%>
            </td>


        </tr>
        <%
            }
        %>
    </table>
    <p>
        <input type="button" class="button"
               value="Add movie" onclick="location='setMovie.jsp'"/>
    </p>

</div>
<div>
    <input type="button" value="Delegate privileges " onclick="location='delegate.jsp'"/>
</div>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
