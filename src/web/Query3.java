package web;

import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query3 {
    public static void main(String[] args) {

        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select * from(select count(*) as count, reviewid from F15_MOVIECOMMENT Group By REVIEWID order by count) where rownum<=3";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String reviewid = res.getString("reviewid");
                String count = res.getString("count");


                System.out.println("reviewid: " + reviewid + ", count: " + count);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
