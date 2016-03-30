<%@ page import="entity.User" %>
<%@ page import="entity.Employee" %>
<%@ page import="entity.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/25/15
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="content">


    <h1>
        Member information update
    </h1>
    <%
        User u = (User) request.getAttribute("u");

    %>

    <form action="modifymember.do?id=<%=u.getId()%>" method="post">
        <table cellpadding="0" cellspacing="0" border="0"
               class="form_table">
            <tr>
                <td valign="middle" align="right">
                    ID:
                </td>
                <td valign="middle" align="left">
                    <%=u.getId()%>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Name:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Phone:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="phone">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Address:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="address">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Password:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="password">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Email:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="email">
                </td>
            </tr>


        </table>

    <span>
        <input type="submit" value="submit">
    </span>
    </form>
</div>
</body>
</html>
