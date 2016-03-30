<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>login</title>

</head>

<body style="font-size: 30px;">
<form action="login.do" method="post">
    <fieldset>
        <legend>Manager Login</legend>
        SSN：<input name="ssn">
            <%
            String msg = (String) request.getAttribute("login_error");
        %>
        <span style="color:red;"><%=(msg == null ? "" : msg)%></span>
        <br>
        Password：<input type="password" name="pwd">
        <!--  <br>
        验证码：<input name="number">
            <%
            String msg2 = (String) request.getAttribute("number_error");
        %>
        <span style="color:red;"><%=(msg2 == null ? "" : msg2)%></span><br>
        <img src="checkcode" border="1" id="img1">
        <a href="javascript:;" onclick="document.getElementById('img1').src='checkcode?'+Math.random();">换一个</a><br> -->
        <input type="submit" value="login">


</form>
<!-- form action="register.jsp">
    <input type="submit" value="register">
</form> -->


<a href="http://localhost:8080/index.jsp">Go back</a>
</body>

</html>