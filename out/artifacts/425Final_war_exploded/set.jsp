<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/14/15
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set worker</title>
</head>
<body>
<h2>Please set the information of a worker</h2>
<form action="add.do" method="post">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">

        <tr>
            <td valign="middle" align="right">
                Staff name:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Phone:
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
                password:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="password"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                SSN:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="ssn"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Theatre id:
                <input id = "1" name="theatreid" type="radio" value="1">
                <label for="1">1</label>
                <input id = "2" name="theatreid" type="radio" value="2">
                <label for="2">2</label>
                <input id = "3" name="theatreid" type="radio" value="3">
                <label for="3">3</label>
            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>


        </tr>
        <tr>
            <td valign="middle" align="right">
               Job:
                <span>
                     <select name="job">
                         <option value="Administer">Administer</option>
                         <option value="Tickets">Tickets Seller</option>
                         <option value="Security">Security</option>
                         <option value="Snack Service Provider">Snack Service Provider</option>


                     </select>

                </span>

            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                <br>
                <fieldset>
                    <legend>Start time:</legend>

                    <select name="start">
                        <option value="07:00:00">7am</option>
                        <option value="08:00:00">8am</option>
                        <option value="09:00:00">9am</option>


                    </select>
                </fieldset>
            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>
        </tr>
        <tr>
            <td valign="middle" align="right">
                <br>
                <fieldset>
                    <legend>End time:</legend>

                    <select name="end">
                        <option value="17:00:00">5pm</option>
                        <option value="18:00:00">6pm</option>
                        <option value="19:00:00">7pm</option>


                    </select>
                </fieldset>
            </td>
            <%--<td valign="middle" align="left">--%>
            <%--<input type="text" name="address"/>--%>
            <%--</td>--%>
        </tr>
    </table>

    <div>
        <input type="submit" value="submit">
    </div>

</form>

<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
