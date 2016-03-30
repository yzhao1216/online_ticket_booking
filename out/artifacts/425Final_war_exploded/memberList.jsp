<%@ page import="entity.MemberInfo" %>
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
    <title>member</title>
</head>
<body>

<div id="wrap">

    <div id="content">
        <%
            MemberInfo mb = (MemberInfo) request.getAttribute("minfo");

        %>
        <span>
      <h1>welcome</h1><h2><%=mb.getName()%>
        </h2>
        </span>
        <table class="table" border="1">
            <tr class="table_header">
                <td>
                    ID:
                </td>
                <td>
                    Name:
                </td>
                <td>
                    Phone:
                </td>
                <td>
                    Address
                </td>
                <td>
                    Email
                </td>
                <td>
                    CreditPoint
                </td>
                <td>
                    Status
                </td>
                <td>
                    Balance
                </td>
                <td>
                    Action
                </td>
            </tr>
            <%--<%--%>

            <%--List<Employee> employees =--%>
            <%--(List<Employee>) request.getAttribute("emplist");--%>
            <%--for (int i = 0; i < employees.size(); i++) {--%>
            <%--Employee e = employees.get(i);--%>
            <%--%>--%>
            <tr>
                <td>
                    <%=mb.getId()%>
                </td>
                <td>
                    <%=mb.getName()%>
                </td>
                <td>
                    <%=mb.getPhone()%>
                </td>
                <td>
                    <%=mb.getAddress()%>
                </td>
                <td>
                    <%=mb.getEmail()%>
                </td>
                <td>
                    <%=mb.getCreditpoint()%>
                </td>
                <td>
                    <%=mb.getStatus()%>
                </td>
                <td>
                    <%=mb.getBalance()%>
                </td>
                <td>
                    <a href="loadmember.do?id=<%=mb.getId()%>">Modify</a>
                    <%--<a href="del.do?id=<%=e.getEmployee()%>">Delete</a>--%>
                </td>
            </tr>
            <%--<%--%>
            <%--}--%>
            <%--%>--%>
        </table>

    </div>
    <div>
        <form action="memberbuy.do" method="post">
            <input type="submit" value="buy">
            <input type="hidden" name="id" value="<%=mb.getId()%>">
        </form>
    </div>

    <div>
        <form action="posttd.do" method="post">
            <input type="submit" value="Post New Thread">
            <input type="hidden" name="id" value="<%=mb.getId()%>">
        </form>
    </div>
    <div>
        <form action="claim.do" method="post">
            <input type="hidden" name="point" value="<%=mb.getCreditpoint()%>">
            <input type="submit" value="Calim reward">
        </form>
    </div>
</div>

<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
