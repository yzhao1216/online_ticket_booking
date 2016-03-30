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
    <title></title>
</head>
<body>
<div>


    <h1>
        Thread list
    </h1>
    <table border="1"  cellspacing="1" cellpadding="1" align="center">
        <tr align="center">
            <td>
                MovieID:
            </td>
            <td>
                Rate:
            </td>
            <td>
                Post Time:
            </td>
            <td>
                Content:
            </td>
            <td>
                UserID:
            </td>
            <td>
                Action:
            </td>

            <%--<li></li>--%>
            <%--<li> </li>--%>
            <%--<li> :</li>--%>
            <%--<li> :</li>--%>
            <%--<li>:</li>--%>
            <%--<li>Reply:</li>--%>
            <%--<li> See reply:</li>--%>


        </tr>


        <%
            MovieThreadDao dao = new MovieThreadDao();

            List<MovieThread> movieThreadList = dao.findAll();
//        for (int i = 0; i < movieThreadList.size(); i++) {
//            MovieThread mt = movieThreadList.get(i);
            for (MovieThread mt : movieThreadList) {
        %>


        <tr>
            <td>
                <%=mt.getMovieID()%>
            </td>
            <td>
                <%=mt.getRating()%>
            </td>
            <td>
                <%=mt.getTime()%>
            </td>
            <td>
                <%=mt.getContent()%>
            </td>
            <td>
                <%=mt.getUid()%>
            </td>
            <td>


                <form action="reply.jsp" method="post">

                    <input type="hidden" name="threadid" value="<%=mt.getId()%>"/>
                    <input type="hidden" name="userid" value="<%=mt.getUid()%>"/>

                    <%--<input type="hidden" name="userid" value="<%=request.getParameter("userid")%>"/>--%>
                    <input type="hidden" name="movieid" value="<%=mt.getMovieID()%>"/>
                    <input type="hidden" name="time" value="<%=mt.getTime()%>"/>
                    <input type="hidden" name="rate" value="<%=mt.getRating()%>"/>
                    <input type="hidden" name="content" value="<%=mt.getContent()%>"/>
                    <input type="submit" value="Reply">

                </form>

                <form action="seereply.do" method="post">

                    <input type="hidden" name="threadid" value="<%=mt.getId()%>">
                    <input type="hidden" name="userid" value="<%=mt.getUid()%>">
                    <input type="submit" value="See reply">

                </form>

            </td>
        </tr>


        <%--<ul>--%>

        <%--<li>--%>
        <%--<%=mt.getMovieID()%>--%>
        <%--</li>--%>
        <%--<li><%=mt.getRating()%>--%>
        <%--</li>--%>
        <%--<li><%=mt.getTime()%>--%>
        <%--</li>--%>
        <%--<li><%=mt.getContent()%>--%>
        <%--</li>--%>
        <%--<li><%=mt.getUid()%>--%>
        <%--</li>--%>


        <%--<form action="reply.jsp" method="post">--%>
        <%--<li>--%>
        <%--<input type="hidden" name="threadid" value="<%=mt.getId()%>"/>--%>
        <%--<input type="hidden" name="userid" value="<%=request.getParameter("userid")%>"/>--%>
        <%--<input type="hidden" name="movidid" value="<%=mt.getMovieID()%>"/>--%>
        <%--<input type="hidden" name="time" value="<%=mt.getTime()%>"/>--%>
        <%--<input type="hidden" name="rate" value="<%=mt.getRating()%>"/>--%>
        <%--<input type="hidden" name="content" value="<%=mt.getContent()%>"/>--%>
        <%--<input type="submit" value="Reply">--%>
        <%--</li>--%>
        <%--</form>--%>
        <%--<form action="seereply.do" method="post">--%>
        <%--<li>--%>
        <%--<input type="hidden" name="threadid" value="<%=mt.getId()%>">--%>
        <%--<input type="hidden" name="userid" value="<%=mt.getUid()%>">--%>
        <%--<input type="submit" value="See reply">--%>
        <%--</li>--%>
        <%--</form>--%>
        <%--&lt;%&ndash;<form action="vote.do" method="post">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="hidden" name="like" value="1">&ndash;%&gt;--%>

        <%--&lt;%&ndash;<input type="hidden" name="threadid" value="<%=mt.getId()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="hidden" name="userid" value="<%=mt.getUid()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="submit" value="Like">&ndash;%&gt;--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<form action="vote.do" method="post">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="hidden" name="like" value="-1">&ndash;%&gt;--%>

        <%--&lt;%&ndash;<input type="hidden" name="threadid" value="<%=mt.getId()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="hidden" name="userid" value="<%=mt.getUid()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="submit" value="Dislike">&ndash;%&gt;--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
        <%--</ul>--%>
        <%
            }
        %>
    </table>
</div>
<div>
    <a href="http://localhost:8080/select.do">Go back</a>
</div>

</body>
</html>
