package web;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query7 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        try {
            String sql = "select * from F15_THEATRE where TICKETCOUNT=(select max(ticketcount)from F15_THEATRE)";
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id = res.getString("id");
                String ticketcount = res.getString("ticketcount");
                String address = res.getString("address");

                System.out.println("id: " + id + ", Ticketcount: " + ticketcount + ",address: " + address);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
