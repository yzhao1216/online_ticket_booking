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
    <title>register</title>
</head>
<body>
<h1>Welcome register</h1>

<form action="register.do" method="post">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">
                Name:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                Password:
            </td>
            <td valign="middle" align="left">
                <input type="password"  name="password"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                email:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="email"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                phone:
            </td>
            <td valign="middle" align="left">
                <input type="text" class="inputgri" name="phone"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                address:
            </td>
            <td valign="middle" align="left">
                <input type="text" class="inputgri" name="address"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                credit card number:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="creditcardnum"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                credit card type:
            <td valign="middle" align="right">
                Card type:
                <input id="master" name="type" type="radio" value="master">
                <label for="master">MasterCard</label>
                <input id="visa" name="type" type="radio" value="visa">
                <label for="visa">VISA</label>
                <input id="discover" name="type" type="radio" value="discover">
                <label for="discover">DISCOVER</label>
            </td>
            </td>
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
                Balance:
            </td>
            <td valign="middle" align="left">
                <input type="text" name="balance"/>
            </td>
        </tr>
    </table>
    <p>
        <input type="submit" class="button"
               value="submit"/>
    </p>
</form>

<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
