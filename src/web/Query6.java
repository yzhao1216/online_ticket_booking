package web;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query6 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        try {
            String sql = "select id,address,count from(select count(*) as count,THEATREID from F15_MOVIESCHEDULE ms, F15_SCREENSROOM sr where ms.SCREENINGROOMNO=sr.id group by THEATREID having count(*)=(select max(count(*))from F15_MOVIESCHEDULE ms, F15_SCREENSROOM sr where ms.SCREENINGROOMNO=sr.id group by THEATREID))a, f15_theatre t where a.theatreid=t.id";
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id = res.getString("id");
                String count = res.getString("count");
                String address = res.getString("address");

                System.out.println("id: " + id + ", count: " + count + ",address: " + address);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
