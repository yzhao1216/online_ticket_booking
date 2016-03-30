package web;


import dao.*;
import entity.*;
import util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by EYlee on 7/28/15.
 */
@WebServlet(name = "ActionServlet")
public class ActionServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        response.setContentType("text/html;charset=utf-8");
        System.out.println(action);

        if (action.equals("/adminload")) {
            String id = request.getParameter("id");
            // PrintWriter out = response.getWriter();


            try {
                MemberInfoDao dao = new MemberInfoDao();
                //EmployeeDao dao = new EmployeeDao();
               User u = dao.findByid(id);

                //使用转发，转发给updateEmp.jsp
                //1绑定数据
                request.setAttribute("u", u);
                //2获得转发器，并转发
                request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
//             response.sendRedirect("error3.jsp");
            } catch (Exception e) {
                response.sendRedirect("error3.jsp");
                e.printStackTrace();
                throw new ServletException(e);

            }



        } else if (action.equals("/delegate")) {
            System.out.println("Hi delegeate");
            String name = request.getParameter("mgname");
            System.out.println(name);
            Connection con = null;
            con = DBUtil.getConnection();
            String sql = "insert into f15_privileges values('" + name + "','Update movie')";
            System.out.println(sql);
            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                System.out.println("insert success");
                request.setAttribute("name", name);
                RequestDispatcher rd = request.getRequestDispatcher("delegateSuccess.jsp");
                rd.forward(request, response);


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        if (action.equals("/managerloadmovie")) {
            System.out.println("Hello");
            String mamagerName = request.getParameter("mname");
            String id = request.getParameter("movieid");
            Connection con = null;

            String sql = "select * from f15_privileges where name='" + mamagerName + "'";
            System.out.println(sql);
            System.out.println(id);

            try {
                con = DBUtil.getConnection();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql);

                if (res.next()) {
                    // PrintWriter out = response.getWriter();


                    try {
                        MovieDao dao = new MovieDao();
                        Movie m = dao.findById(Integer.parseInt(id));


                        //使用转发，转发给updateEmp.jsp
                        //1绑定数据
                        request.setAttribute("m", m);
                        //2获得转发器，并转发
                        request.getRequestDispatcher("managerMovieUpdate.jsp").forward(request, response);
//             response.sendRedirect("error3.jsp");
                    } catch (Exception e) {
                        response.sendRedirect("error3.jsp");
                        e.printStackTrace();
                        throw new ServletException(e);

                    }
                } else {
                    response.sendRedirect("priviligeerror.jsp");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (action.equals("/claim")) {
            String point = request.getParameter("point");
            int apoint = Integer.parseInt(point);
            RewardDao dao = new RewardDao();
            try {
                List<Rewards> rewardses = dao.findByPoint(apoint);
                request.setAttribute("rewardses", rewardses);
                RequestDispatcher rd = request.getRequestDispatcher("claimreword.jsp");
                rd.forward(request, response);


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (action.equals("/seereply")) {
            String userid = request.getParameter("userid");
            String threadid = request.getParameter("threadid");

            MovieCommentDao dao = new MovieCommentDao();

            List<MovieComment> movieCommentList = dao.getCommentDetail(Integer.parseInt(userid), Integer.parseInt(threadid));
            if (movieCommentList.isEmpty()) {
                response.sendRedirect("seereplyerror.jsp");
            } else {
                System.out.println(movieCommentList.get(0).toString());
                request.setAttribute("movieCommentList", movieCommentList);
                RequestDispatcher rd = request.getRequestDispatcher("seereply.jsp");
                rd.forward(request, response);
            }

        } else if (action.equals("/reply")) {
            String threadid = request.getParameter("threadid");
            String userid = request.getParameter("userid");
            String content = request.getParameter("reply");
            MovieComment mc = new MovieComment();
            MovieCommentDao dao = new MovieCommentDao();
            int uid = Integer.parseInt(userid);
            System.out.println(uid);
            System.out.println(content);

            mc.setThreadid(Integer.parseInt(threadid));
            mc.setUserid(uid);
            mc.setCommenttext(content);

            if (dao.saveComment(mc)) {
                StatusDao s_dao = new StatusDao();

                s_dao.addCreditBuyticket(uid);
                response.sendRedirect("postReplySuccess.jsp");
                System.out.println("save content success");
            } else {
                System.out.println("ERROR Save");
            }


        } else if (action.equals("/posttd")) {
            String uid = request.getParameter("id");

            request.setAttribute("uid", uid);
            RequestDispatcher rd = request.getRequestDispatcher("choose.jsp");
            rd.forward(request, response);


        } else if (action.equals("/postThread")) {
            String movieid = request.getParameter("id");
            String content = request.getParameter("textarea");
            String uid = request.getParameter("uid");
            String rate = request.getParameter("rate");

            System.out.println(uid);
            MovieThread mt = new MovieThread();
            mt.setMovieID(Integer.parseInt(movieid));
            mt.setRating(Integer.parseInt(rate));
            mt.setContent(content);
            mt.setUid(Integer.parseInt(uid));
            int id = Integer.parseInt(uid);
            System.out.println("!!!!!!!!!:" + id);
            MovieThreadDao dao = new MovieThreadDao();


            if (dao.saveThread(mt)) {

                StatusDao s_dao = new StatusDao();
//                int countThread = s_dao.findThread(id);
//                int countComment = s_dao.findConmment(id);
//                int creditpoint = countThread*2+countComment;
                s_dao.addCreditBuyticket(id);
//                s_dao.findStatus()


                response.sendRedirect("postThreadSuccess.jsp");
                System.out.println("Save thread success");
            } else {
                System.out.println("Save faild");
            }


        } else if (action.equals("/addmovie")) {
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String description = request.getParameter("description");
            // String password = request.getParameter("password");


            response.setContentType("text/html;charset=utf-8");

            try {
                MovieDao dao = new MovieDao();
                Movie m = new Movie();


                m.setTitle(title);
                m.setDirector(director);
                m.setDescription(description);
                //user

                dao.save(m);

                //staff


                response.sendRedirect("updateSuccess.jsp");

            } catch (NumberFormatException n) {
                n.printStackTrace();
                response.sendRedirect("set.jsp");


            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }


        }

        if (action.equals("/modifymovie")) {
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String description = request.getParameter("description");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("date");
            String time = request.getParameter("time");

            String str = year + "-" + month + "-" + day + " " + time;
            System.out.println(str);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date movietime = new Date();
            try {
                movietime = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // Connection con = null;
            System.out.println(id + "," + title + "." + director + "." + description);

            try {
                MovieDao dao = new MovieDao();
                MovieSchedule ms = new MovieSchedule();
                Movie m = new Movie();
                ms.setTime(str);
                ms.setMovieID(Integer.parseInt(id));

                m.setId(Integer.parseInt(id));
                m.setTitle(title);
                m.setDirector(director);
                m.setDescription(description);
                dao.modify(m);
                dao.modifytime(ms);
                System.out.println("******");
                response.sendRedirect("movieUpdateSuccess.jsp");


            } catch (NumberFormatException n) {
                n.printStackTrace();

                response.sendRedirect("movieUpdate.jsp");
            } catch (SQLException se) {

                se.printStackTrace();
                System.out.println("***222222");
                response.sendRedirect("uniqueerror.jsp");
            } catch (Exception e) {
                System.out.println("***33333");
                e.printStackTrace();
                throw new ServletException(e);
            }


        } else if (action.equals("/loadmovie")) {
            String id = request.getParameter("id");
            // PrintWriter out = response.getWriter();


            try {
                MovieDao dao = new MovieDao();
                Movie m = dao.findById(Integer.parseInt(id));


                //使用转发，转发给updateEmp.jsp
                //1绑定数据
                request.setAttribute("m", m);
                //2获得转发器，并转发
                request.getRequestDispatcher("movieUpdate.jsp").forward(request, response);
//             response.sendRedirect("error3.jsp");
            } catch (Exception e) {
                response.sendRedirect("error3.jsp");
                e.printStackTrace();
                throw new ServletException(e);

            }


        } else if (action.equals("/loadmember")) {
            String id = request.getParameter("id");
            // PrintWriter out = response.getWriter();


            try {
                UserDao dao = new UserDao();
                User u = dao.findByid(id);


                //使用转发，转发给updateEmp.jsp
                //1绑定数据
                request.setAttribute("u", u);
                //2获得转发器，并转发
                request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
//             response.sendRedirect("error3.jsp");
            } catch (Exception e) {
                response.sendRedirect("error3.jsp");
                e.printStackTrace();
                throw new ServletException(e);

            }

        } else if (action.equals("/select")) {
            String type = request.getParameter("type");
            System.out.println(type);
            String name = request.getParameter("user");
            String pwds = request.getParameter("password");

            Connection con = null;
            try {
                con = DBUtil.getConnection();
                Statement st = con.createStatement();
                String sql = "select * from f15_user where name ='" + name + "'and password='" + pwds + "'";
                System.out.println(sql);
                ResultSet res = st.executeQuery(sql);
                if (res.next()) {
                    sql = "select id from (select * from f15_user where name ='" + name + "'and password='" + pwds + "')";
                    System.out.println(sql);
                    res = st.executeQuery(sql);

                    if (res.next()) {
                        String id = res.getString("id");
                        sql = "select * from f15_enrollment where employee = ( select ssn from f15_staff where userid=" + id + ")";
                        System.out.println(sql);
                        res = st.executeQuery(sql);

                        if (res.next()) {
                            String job = res.getString("job");
                            if ("Administer".equals(job)) {
                                MemberInfoDao dao = new MemberInfoDao();
                                System.out.println("List 1");


                                List<MemberInfo> memberInfos = null;
                                try {
                                    memberInfos = dao.findAll();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                request.setAttribute("memberInfos", memberInfos);
                                RequestDispatcher rd = request.getRequestDispatcher("webAdminList.jsp");
                                rd.forward(request, response);
                            } else if ("Onwer".equals(job)) {

                                MemberInfoDao dao = new MemberInfoDao();
                                MovieDao m_dao = new MovieDao();
                                System.out.println("List 1");


                                List<MemberInfo> memberInfos = null;
                                try {
                                    memberInfos = dao.findAll();
                                    List<MovieInfo> movies = m_dao.findAllInfo(name);
                                    request.setAttribute("memberInfos", memberInfos);
                                    request.setAttribute("movies", movies);

                                    RequestDispatcher rd = request.getRequestDispatcher("ownerList.jsp");
                                    rd.forward(request, response);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            } else if ("Manager".equals(job)) {
                                MovieDao m_dao = new MovieDao();


                                List<MovieInfo> movies = null;
                                try {
                                    movies = m_dao.findAllInfo(name);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                request.setAttribute("mname", name);
                                request.setAttribute("movies", movies);
                                RequestDispatcher rd = request.getRequestDispatcher("manageList.jsp");
                                rd.forward(request, response);

                            } else {
                                System.out.println("There is no idea");
                            }
                        } else {
                            MemberInfoDao dao = new MemberInfoDao();
                            MemberInfo minfo = dao.findByName(name);
                            request.setAttribute("minfo", minfo);
                            RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");
                            rd.forward(request, response);
                        }

                    } else {
//                        MemberInfoDao dao = new MemberInfoDao();
//                        MemberInfo minfo = dao.findByName(name);
//                        request.setAttribute("minfo", minfo);
//                        RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");
//                        rd.forward(request, response);
                        System.out.println("This will never happen");
                    }
                } else {
                    //error username or password 或者 他是user
                    request.setAttribute("login_error", "SSN or Password error");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DBUtil.close(con);
            }


        } else if (action.equals("/del")) {
            String id = (request.getParameter("id"));


            try {
                EmployeeDao dao = new EmployeeDao();
                Employee e = dao.findByid(id);
                dao.delete(e);

                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (action.equals("/register")) {
            System.out.println("111");
            request.setCharacterEncoding("utf-8");
            try {
                String name = request.getParameter("name");
                System.out.println(name);
                System.out.println("111");

                String pwd = request.getParameter("password");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String creditCardNum = request.getParameter("creditcardnum");
                String creditCardType = request.getParameter("type");
                String month = request.getParameter("month");
                String year = request.getParameter("year");
                String expirationdate = month + "/" + year;

                String balance = request.getParameter("balance");
                System.out.println("get dfsdfa success");
                response.setContentType("text/html; charset=utf-8");

                // save credit information
                Creditcard c = new Creditcard();
                CreditCardDao c_dao = new CreditCardDao();
                c.setCreditcardnum(creditCardNum);
                c.setCredittype(creditCardType);
                c.setExpirationdate(expirationdate);
                c.setBalance(Double.parseDouble(balance));
                c_dao.save(c);
                System.out.println("Save success");
                //save user
                User u = new User();

                u.setName(name);
                u.setPhone(phone);
                u.setAddress(address);
                u.setPassword(pwd);
                UserDao u_dao = new UserDao();
                u_dao.save(u);


                //get the auto create id
                int godID = u_dao.findID(u);

                System.out.println(u.toString());

                //save member
                Member6 m = new Member6();
                MemberDao m_dao = new MemberDao();
                m.setUserid(godID);
                m.setPassword(pwd);
                m.setEmail(email);
                m.setPhone(phone);
                m.setAddress(address);
                m_dao.save(m, c);
                System.out.println("member Save success");
                response.sendRedirect("registerSuccess.jsp");

            } catch (NumberFormatException num) {
                num.printStackTrace();
                response.sendRedirect("register.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("/buy")) {
            System.out.println("buy");

            double price = 0;
            String uid = request.getParameter("id");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String cardnum = request.getParameter("creditCardNum");
            String type = request.getParameter("type");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String expirationdate = month + "/" + year;
            String funds = request.getParameter("funds");

            String theatreID = request.getParameter("theater");


            System.out.println("thea:" + theatreID);
            String MovieID = request.getParameter("movie");
            System.out.println("movei:" + MovieID);
            System.out.println(cardnum + "," + type + "," + expirationdate + "," + funds);
            if (cardnum == null || type == null || expirationdate == null || funds == null) {

                System.out.println("111");

                System.out.println(cardnum + "," + type + "," + expirationdate);
                response.sendRedirect("error.jsp");
            }
            try {
                TicketDao t_dao = new TicketDao();
                price = t_dao.findPrice(Integer.parseInt(MovieID), Integer.parseInt(theatreID));

                System.out.println("Price***" + price);

                if (Double.parseDouble(funds) < price) {
                    request.setAttribute("price", price);
                    request.setAttribute("funds", funds);
                    RequestDispatcher rd = request.getRequestDispatcher("error2.jsp");
                    rd.forward(request, response);

                } else {
                    //count ticket
                    Theater th = new Theater();
                    TheatreDao th_dao = new TheatreDao();
                    try {
                        //System.out.println("bf:"+th.getTicketCount());
                        th_dao.modify(Integer.parseInt(theatreID));
                        //th.addCount();
                        System.out.println("modify success");
                        //  System.out.println("after:"+th.getTicketCount());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    response.sendRedirect("success.jsp");
                }


            } catch (NumberFormatException num) {
                num.printStackTrace();
                response.sendRedirect("error.jsp");

            } catch (Exception e) {
                e.printStackTrace();
//                response.sendRedirect("error.jsp");
            } finally {
                if (!response.isCommitted()) {
                    response.sendRedirect("error.jsp");
                }

            }


        } else if (action.equals("/modifymember")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            // Connection con = null;


            try {
                UserDao dao = new UserDao();
                MemberDao m_dao = new MemberDao();

                User u = new User();
                MemberInfo m = new MemberInfo();
                m.setId(Integer.parseInt(id));
                m.setEmail(email);
                u.setId(Integer.parseInt(id));
                u.setName(name);
                u.setPhone(phone);
                u.setAddress(address);
                u.setPassword(password);
                dao.modify(u);
                m_dao.modify(m);
                System.out.println("******");
                response.sendRedirect("updateSuccess.jsp");


            } catch (NumberFormatException n) {
                n.printStackTrace();

                response.sendRedirect("update.jsp");
            } catch (SQLException se) {

                se.printStackTrace();
                System.out.println("***222222");
                response.sendRedirect("uniqueerror.jsp");
            } catch (Exception e) {
                System.out.println("***33333");
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if (action.equals("/modify")) {

            //PrintWriter out = response.getWriter();
            String employee = request.getParameter("employee");
            String theatreid = request.getParameter("theatreid");
            String job = request.getParameter("job");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            // Connection con = null;


            try {
                EmployeeDao dao = new EmployeeDao();
                Employee e = new Employee();
                e.setEmployee(Integer.parseInt(employee));
                e.setTheatreid(Integer.parseInt(theatreid));
                e.setJob(job);
                e.setWorkingtimestart(start);
                e.setWorkingtimeend(end);
                dao.modify(e);
                System.out.println("******");
                response.sendRedirect("list.do");


            } catch (NumberFormatException n) {
                n.printStackTrace();

                response.sendRedirect("update.jsp");
            } catch (SQLException se) {

                se.printStackTrace();
                System.out.println("***222222");
                response.sendRedirect("uniqueerror.jsp");
            } catch (Exception e) {
                System.out.println("***33333");
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if (action.equals("/load")) {
            String id = request.getParameter("id");
            // PrintWriter out = response.getWriter();


            try {
                EmployeeDao dao = new EmployeeDao();
                Employee e = dao.findByid(id);

                //使用转发，转发给updateEmp.jsp
                //1绑定数据
                request.setAttribute("e", e);
                //2获得转发器，并转发
                request.getRequestDispatcher("update.jsp").forward(request, response);
//             response.sendRedirect("error3.jsp");
            } catch (Exception e) {
                response.sendRedirect("error3.jsp");
                e.printStackTrace();
                throw new ServletException(e);

            }
        } else if (action.equals("/add")) {


            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String password = request.getParameter("password");

            String ssn = request.getParameter("ssn");

            String theatreid = request.getParameter("theatreid");
            String job = request.getParameter("job");
            String start = request.getParameter("start");
            String end = request.getParameter("end");

            response.setContentType("text/html;charset=utf-8");

            try {
                EmployeeDao dao = new EmployeeDao();
                Employee e = new Employee();

                Stuff s = new Stuff();
                StuffDao s_dao = new StuffDao();

                UserDao u_dao = new UserDao();
                User u = new User();

                //user
                u.setName(name);
                u.setPhone(phone);
                u.setAddress(address);
                u.setPassword(password);
                u_dao.save(u);

                //staff
                s.setSsn(Integer.parseInt(ssn));
                s_dao.save(s, u);

                //enrollment
                e.setEmployee(s.getSsn());
                e.setTheatreid(Integer.parseInt(theatreid));
                e.setJob(job);
                e.setWorkingtimestart(start);
                e.setWorkingtimeend(end);
                e.setPassword(u.getPassword());
                dao.save(e);

                response.sendRedirect("list.do");

            } catch (NumberFormatException n) {
                n.printStackTrace();
                response.sendRedirect("set.jsp");


            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if (action.equals("/list")) {
            EmployeeDao dao = new EmployeeDao();
            System.out.println("List 1");

            try {
                List<Employee> employees = dao.findAll();
                request.setAttribute("emplist", employees);
                RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("/memberbuy")) {
            MovieDao dao = new MovieDao();
            TheatreDao dao1 = new TheatreDao();
            System.out.println("guest 1");
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                List<Movie> movies = dao.findAll();
                request.setAttribute("movielist", movies);
                List<Theater> theaters = dao1.findAll();
                request.setAttribute("theaterlist", theaters);
                request.setAttribute("id", id);
                RequestDispatcher rd = request.getRequestDispatcher("movieList.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("/guestList")) {
            MovieDao dao = new MovieDao();
            TheatreDao dao1 = new TheatreDao();
            System.out.println("guest 1");

            try {
                List<Movie> movies = dao.findAll();
                request.setAttribute("movielist", movies);
                List<Theater> theaters = dao1.findAll();
                request.setAttribute("theaterlist", theaters);
                RequestDispatcher rd = request.getRequestDispatcher("buyTicket.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equals("/meBuy")) {
            System.out.println("*****------");
            double price = 0;
            TicketDao t_dao = new TicketDao();
            FindBalanceDao f_dao = new FindBalanceDao();
            String movie = request.getParameter("movie");
            String theatre = request.getParameter("theater");
            price = t_dao.findPrice(Integer.parseInt(movie), Integer.parseInt(theatre));
            System.out.println("movie:" + movie);
            System.out.println("the:" + theatre);

            int id = Integer.parseInt(request.getParameter("id"));

            double balance = f_dao.findBalance(id);

            try {

                System.out.println("Price***" + price);

                if (balance < price) {
                    request.setAttribute("price", price);
                    request.setAttribute("balance", balance);
                    RequestDispatcher rd = request.getRequestDispatcher("notEnouthBalance.jsp");
                    rd.forward(request, response);

                } else {
                    //count ticket
                    //Theater th = new Theater();
                    TheatreDao th_dao = new TheatreDao();
                    try {
                        //System.out.println("bf:"+th.getTicketCount());
                        th_dao.modify(Integer.parseInt(theatre));
                        //
                        StatusDao dao = new StatusDao();
                        dao.addCreditBuyticket(id);
                        dao.decreaseBalance(id, price);

                        System.out.println("add buy ticket credit success");


                        //th.addCount();

                        System.out.println("modify success");
                        //  System.out.println("after:"+th.getTicketCount());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    response.sendRedirect("memberBuySuccess.jsp");
                }


            } catch (NumberFormatException num) {
                num.printStackTrace();
                response.sendRedirect("error.jsp");

            } catch (Exception e) {
                e.printStackTrace();
//                response.sendRedirect("error.jsp");
            } finally {
                if (!response.isCommitted()) {
                    response.sendRedirect("error.jsp");
                }

            }
            System.out.println("ID:" + id);


        }

//

    }
}


