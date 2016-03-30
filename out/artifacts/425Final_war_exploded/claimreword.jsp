<%@ page import="entity.Rewards" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/30/15
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>
    claim rewords
</h1>
<table class="table" border="1">
    <tr class="table_header">
        <td>
            Reword Name:
        </td>
        <td>
            Worth point:
        </td>
        <td>
           Claim:
        </td>


    </tr>
    <%

        List<Rewards> rewardsList =
                (List<Rewards>) request.getAttribute("rewardses");
        for (int i = 0; i < rewardsList.size(); i++) {
            Rewards e = rewardsList.get(i);
    %>
    <tr class="row<%=(i % 2 + 1) %>">
        <td>
            <%=e.getName()%>
        </td>
        <td>
            <%=e.getWorthPoint()%>
        </td>

        <td>
            <a href="claimsuccess.jsp">Claim</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
