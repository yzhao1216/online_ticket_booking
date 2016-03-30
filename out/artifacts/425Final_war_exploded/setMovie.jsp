<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/25/15
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Please set the information of a worker</h2>
<form action="addmovie.do" method="post">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">

        <tr>
            <td valign="middle" align="right">
                Title:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="title"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Director:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="director"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Description:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="description"/>
            </td>
        </tr>
        </table>
    <input type="submit" value="submit">
    </form>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
