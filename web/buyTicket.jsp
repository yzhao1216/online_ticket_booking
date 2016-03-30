<%@ page import="entity.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Theater" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/13/15
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BuyTicket</title>
</head>
<body>
<h1>buy ticket function</h1>

<form action="buy.do" method="post">
    <table  cellspacing="1" cellpadding="1" align="center">

        <tr>
            <td valign="middle" align="right">
                userid:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="id"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                name:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                phone:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="phone"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                address:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="address"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                credit Card Num:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="creditCardNum"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Card type:
                <input id="master" name="type" type="radio" value="master">
                <label for="master">MasterCard</label>
                <input id="visa" name="type" type="radio" value="visa">
                <label for="visa">VISA</label>
                <input id="discover" name="type" type="radio" value="discover">
                <label for="discover">DISCOVER</label>
            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>


        </tr>
        <tr>
            <td valign="middle" align="right">
                expiration Date:
                <span>
                     <select name="month">
                         <option value="01">Jan</option>
                         <option value="02">Feb</option>
                         <option value="03">Mar</option>
                         <option value="04">Apr</option>
                         <option value="05">May</option>
                         <option value="06">Jun</option>
                         <option value="07">Jul</option>
                         <option value="08">Aug</option>
                         <option value="09">Sep</option>
                         <option value="10">Oct</option>
                         <option value="11">Nov</option>
                         <option value="12">Dec</option>

                     </select>
                     <select name="year">
                         <option value="2017">2017</option>
                         <option value="2018">2018</option>
                         <option value="2019">2019</option>
                         <option value="2020">2020</option>
                         <option value="2021">2017</option>
                         <option value="2022">2018</option>
                         <option value="2023">2019</option>
                         <option value="2024">2020</option>


                     </select>
                </span>

            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                funds:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="funds"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                <br>

                <div>


                    <h1>
                        Theatre Select
                    </h1>
                    <table border="1" cellspacing="1" cellpadding="1" align="center">
                        <tr>
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

                <%--<fieldset>--%>
                <%--<legend>theatre:</legend>--%>

                <%--<select name="theatre">--%>
                <%--<option value="1">1751 S State St</option>--%>
                <%--<option value="2">2701 S King Road</option>--%>
                <%--<option value="3">Chinatown</option>--%>


                <%--</select>--%>
                <%--</fieldset>--%>
            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>
        </tr>
        <tr>
            <td valign="middle" align="right">
                <br>


                <h1>
                        Movie Select
                    </h1>
                <table border="1" cellspacing="1" cellpadding="1" align="center">
                    <tr>
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

                <%--<legend>Movie:</legend>--%>

                <%--<select name="movie">--%>
                <%--<option value="1">007Spectre</option>--%>
                <%--<option value="2">The hunger games</option>--%>
                <%--<option value="3">ant-man</option>--%>


                <%--</select>--%>

            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>
        </tr>
    </table>
    <div>
        <%--<form action="buyTicket.jsp">--%>
        Movie:<input type="text" name="movie">
        Theater:<input type="text" name="theater">
        <input type="submit" value="submit">
        <%--</form>--%>
    </div>

    <%--<div>--%>
    <%--<input type="submit" value="submit">--%>
    <%--</div>--%>

</form>
<form action="otherList.jsp" method="post">
    <input type="submit" value="See Thread">
</form>

<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
