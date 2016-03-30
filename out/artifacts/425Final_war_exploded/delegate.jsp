<%@ page import="java.util.List" %>
<%@ page import="entity.Employee" %>
<%@ page import="dao.StaffNameDao" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 12/1/15
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>delegate to a manager</h1>
<% StaffNameDao dao = new StaffNameDao();
  //  StaffNameDao s_dao = new StaffNameDao();
    List<String> namelist = dao.findAllName();

   // List<String> joblist = s_dao.findAllJob();
   // Iterator jobitr = joblist.iterator();
    //System.out.println(namelist.get(2));
    Iterator itr = namelist.iterator();
    //String name = "";
    // System.out.println("DDDDDD"+itr.next());

%>
<%--Select Manager name: <select name="managerName">--%>
<% while (itr.hasNext()) {
    String name = (String) itr.next();
   // String job = (String) jobitr.next();
%>
<option name="managerName" value="<%=name%>"><%=name%>
</option>

</select>
<select name="job">
    <option name="job" value="job">Update Movie</option>
</select>

<form action="delegate.do" method="post">
    <input type="submit" value="Delegate">

    <input type="hidden" value="<%=name%>" name="mgname">
    <input type="hidden" value="Update Movie" name="job">

</form>
<% }%>
<a href="http://localhost:8080/index.jsp">Go back</a>

</body>
</html>
