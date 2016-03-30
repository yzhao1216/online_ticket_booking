<%@page pageEncoding="utf-8"
        contentType="text/html;charset=utf-8" %>
<%@page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css"/>
</head>

<body>
<div id="wrap">
    <div id="top_content">

        <div id="content">


            <h1>
                update worker
            </h1>
            <%
                Employee e = (Employee) request.getAttribute("e");
            %>

            <form action="modify.do?employee=<%=e.getEmployee()%>" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            SSN:
                        </td>
                        <td valign="middle" align="left">
                            <%=e.getEmployee()%>
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
                    </tr>
                </table>

                <p>
                    <input type="submit" class="button"
                           value="Submit"/>
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
