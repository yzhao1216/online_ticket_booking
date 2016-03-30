package web;

import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query8 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        try {
            String sql = "select name,job,theatreid,workingtimestart,to_char(workingtimestart,'Day') as day from(select * from (select * from F15_ENROLLMENT where to_char(WORKINGTIMESTART,'Day')=(select to_char(to_date('2015-11-09','yyyy-MM-dd'),'Day') from dual) and theatreid = 2) a , f15_staff s where a.employee=s.ssn) b, f15_user u where b.userid= u.id";
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String name = res.getString("name");
                String job = res.getString("job");
                String theatreid = res.getString("theatreid");
                Time time = res.getTime("workingtimestart");
                Date date = res.getDate("workingtimestart");
                SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm:ss");

                String thetime = sdftime.format(time);
                String thedate = sdfdate.format(date);
                String finaltime = thedate + " " + thetime;
                String day = res.getString("day");

                System.out.println("name: " + name + ", job: " + job + ",theatreID: " + theatreid + ",workingtimestart: " + finaltime + ",day: " + day);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
