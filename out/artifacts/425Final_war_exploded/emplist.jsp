<%@page pageEncoding="utf-8"
        contentType="text/html;charset=utf-8" %>
<%@page import="java.util.*,java.text.*" %>
<%@page import="entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Worker schedule</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div id="wrap">

    <div id="content">


        <h1>
            Worker schedule
        </h1>
        <table class="table" border="1">
            <tr class="table_header">
                <td>
                    SSN:
                </td>
                <td>
                    Theatre id:
                </td>
                <td>
                    JOB:
                </td>
                <td>
                    Start:
                </td>
                <td>
                    End:
                </td>
                <td>
                    Action
                </td>
            </tr>
            <%

                List<Employee> employees =
                        (List<Employee>) request.getAttribute("emplist");
                for (int i = 0; i < employees.size(); i++) {
                    Employee e = employees.get(i);
            %>
            <tr class="row<%=(i % 2 + 1) %>">
                <td>
                    <%=e.getEmployee()%>
                </td>
                <td>
                    <%=e.getTheatreid()%>
                </td>
                <td>
                    <%=e.getJob()%>
                </td>
                <td>
                    <%=e.getWorkingtimestart()%>
                </td>
                <td>
                    <%=e.getWorkingtimeend()%>
                </td>
                <td>
                    <a href="load.do?id=<%=e.getEmployee()%>">Modify</a>
                    <a href="del.do?id=<%=e.getEmployee()%>">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <p>
            <input type="button" class="button"
                   value="Set worker" onclick="location='set.jsp'"/>
        </p>
    </div>

</div>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
