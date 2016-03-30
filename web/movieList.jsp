<%@ page import="java.util.List" %>
<%@ page import="entity.Movie" %>
<%@ page import="entity.Theater" %>
<%@ page import="java.util.Objects" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/24/15
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member visit</title>
</head>
<body>

<div>


    <h1>
            Movie Select
        </h1>
    <table class="table" border="1">
        <tr class="table_header">
            <td>
                id:
            </td>
            <td>
                title:
            </td>
            <td>
                director:
            </td>
            <td>
                description:
            </td>

        </tr>
        <%

            List<Movie> movies =
                    (List<Movie>) request.getAttribute("movielist");
            for (int i = 0; i < movies.size(); i++) {
                Movie m = movies.get(i);
        %>
        <tr class="row<%=(i % 2 + 1) %>">
            <td>
                <%=m.getId()%>
            </td>
            <td>
                <%=m.getTitle()%>
            </td>
            <td>
                <%=m.getDirector()%>
            </td>
            <td>
                <%=m.getDescription()%>
            </td>


        </tr>
        <%
            }
        %>
    </table>

</div>



<div>


    <h1>
            Theatre Select
        </h1>
    <table class="table" border="1" style="solid-color: eee">
        <tr class="table_header">
            <td>
                id:
            </td>
            <td>
                address:
            </td>
            <td>
                ticketSold:
            </td>


        </tr>
        <%

            List<Theater> theaters =
                    (List<Theater>) request.getAttribute("theaterlist");
            for (int i = 0; i < theaters.size(); i++) {
                Theater t = theaters.get(i);

        %>
        <tr class="row<%=(i % 2 + 1) %>">
            <td>
                <%=t.getId()%>
            </td>
            <td>
                <%=t.getAddress()%>
            </td>
            <td>
                <%=t.getTicketCount()%>
            </td>


        </tr>
        <%
            }
        %>
    </table>

</div>




<div>
    <%Object id = request.getAttribute("id");


    %>
    <form action="meBuy.do" method="post">
        Movie:<input type="text" name="movie">
        Theater:<input type="text" name="theater">
        <input type="hidden" name="id" value="<%=id%>">
    <input type="submit" value="buy">
    </form>
</div>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
