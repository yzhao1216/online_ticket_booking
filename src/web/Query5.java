package web;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query5 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select count(*) as count,userid from F15_MOVIECOMMENT group by userid having count(*)>= all(select count(*) from F15_MOVIECOMMENT group by userid)";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String userid = res.getString("userid");
                String count = res.getString("count");


                System.out.println("userid: " + userid + ", count: " + count);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
