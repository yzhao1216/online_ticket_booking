<%@ page import="dao.MovieThreadDao" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.MovieThread" %>
<%--
  Created by IntelliJ IDEA.
  User: EYlee
  Date: 11/26/15
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Theatre thread</title>
</head>
<body>
<div>


    <h1>
        Thread list
    </h1>
    <ul>

        <li>Theatre ID:</li>
        <li> Rate:</li>
        <li> Post Time:</li>
        <li> Content:</li>
        <li>UserID:</li>
        <li>Reply:</li>
        <li> See reply:</li>


    </ul>
    <%
        MovieThreadDao dao = new MovieThreadDao();

        List<MovieThread> movieThreadList = dao.findAll();
//        for (int i = 0; i < movieThreadList.size(); i++) {
//            MovieThread mt = movieThreadList.get(i);
        for (MovieThread mt : movieThreadList) {
    %>
    <ul>

        <li>
            <%=mt.getMovieID()%>
        </li>
        <li><%=mt.getRating()%>
        </li>
        <li><%=mt.getTime()%>
        </li>
        <li><%=mt.getContent()%>
        </li>
        <li><%=mt.getUid()%>
        </li>


        <form action="reply.jsp" method="post">
            <li>
                <input type="hidden" name="threadid" value="<%=mt.getId()%>"/>
                <input type="hidden" name="userid" value="<%=request.getParameter("userid")%>"/>
                <input type="hidden" name="movidid" value="<%=mt.getMovieID()%>"/>
                <input type="hidden" name="time" value="<%=mt.getTime()%>"/>
                <input type="hidden" name="rate" value="<%=mt.getRating()%>"/>
                <input type="hidden" name="content" value="<%=mt.getContent()%>"/>
                <input type="submit" value="Reply">
            </li>
        </form>
        <form action="seereply.do" method="post">
            <li>
                <input type="hidden" name="threadid" value="<%=mt.getId()%>">
                <input type="hidden" name="userid" value="<%=mt.getUid()%>">
                <input type="submit" value="See reply">
            </li>
        </form>
        <form action="vote.do" method="post">
            <input type="hidden" name="like" value="1">

            <input type="hidden" name="threadid" value="<%=mt.getId()%>">
            <input type="hidden" name="userid" value="<%=mt.getUid()%>">
            <input type="submit" value="Like">
        </form>
        <form action="vote.do" method="post">
            <input type="hidden" name="like" value="-1">

            <input type="hidden" name="threadid" value="<%=mt.getId()%>">
            <input type="hidden" name="userid" value="<%=mt.getUid()%>">
            <input type="submit" value="Dislike">
        </form>
    </ul>
    <%
        }
    %>
</div>
<div>
    <a href="http://localhost:8080/select.do">Go back</a>
</div>

</body>
</html>
