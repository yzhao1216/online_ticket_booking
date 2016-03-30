package web;

import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query2 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select * from (select REVIEWID,CONTENT,USERID,TIME from F15_MOVIECOMMENT order BY TIME DESC) where rownum<=3";

        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String reviewid = res.getString("reviewid");
                String content = res.getString("content");
                String userid = res.getString("userid");
                Time time = res.getTime("time");
                Date date = res.getDate("time");
                SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm:ss");

                String thetime = sdftime.format(time);
                String thedate = sdfdate.format(date);
                String finaltime = thedate + " " + thetime;
                System.out.println("reviewid: "+reviewid+", content: "+content+",userid: "+userid+",Time: "+finaltime);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
