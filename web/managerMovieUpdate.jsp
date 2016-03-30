<%@ page import="entity.Movie" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/25/15
  Time: 11:35 PM
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
        update movie
    </h1>
    <%
        Movie m = (Movie) request.getAttribute("m");

    %>

    <form action="modifymovie.do?id=<%=m.getId()%>" method="post">
        <table cellpadding="0" cellspacing="0" border="0"
               class="form_table">
            <tr>
                <td valign="middle" align="right">
                    ID:
                </td>
                <td valign="middle" align="left">
                    <%=m.getId()%>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Title:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="title">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Director:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="director">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Description:
                </td>
                <td valign="middle" align="left">
                    <input type="text" name="description">
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    Time:
                </td>
                <td valign="middle" align="left">
                    <select name="year">
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>


                    </select>
                    <select name="month">
                        <option value="01">Jan</option>
                        <option value="02">Feb</option>
                        <option value="03">Mar</option>
                        <option value="04">Apr</option>
                        <option value="05">May</option>
                        <option value="06">Jun</option>

                    </select>

                    <select name="date">
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>

                    </select>
                    <select name="time">
                        <option value="07:00:00">7am</option>
                        <option value="08:00:00">8am</option>
                        <option value="09:00:00">9am</option>


                    </select>
                </td>
            </tr>
            <%--<tr>--%>
            <%--<td valign="middle" align="right">--%>
            <%--Password:--%>
            <%--</td>--%>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="password">--%>
            <%--</td>--%>
            <%--</tr>--%>


        </table>

    <span>
        <input type="submit" value="submit">
    </span>
    </form>
</div>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
