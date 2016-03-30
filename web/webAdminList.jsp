<%@ page import="entity.MemberInfo" %>
<%@ page import="java.util.List" %>
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
this is web admin page
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
        <td>
            Action:
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
        <td>
            <a href="adminload.do?id=<%=m.getId()%>">Modify</a>

        </td>


    </tr>
    <%
        }
    %>
</table>
</body>
</html>
