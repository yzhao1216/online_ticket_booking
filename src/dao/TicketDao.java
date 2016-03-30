package dao;

import entity.Employee;
import entity.Movie;
import entity.Theater;
import util.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by EYlee on 11/13/15.
 */
public class TicketDao {
    public double findPrice(int m, int t) {
        Connection con = null;
        double price = 0;
        try {
            con = DBUtil.getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT price FROM (SELECT f6_screensroom sc JOIN f6_movieschedule ms ON sc.id=ms.screeningroomno) a WHERE a.movieid =? and a.theatreid=?");
            Statement st = con.createStatement();
            String sql = "SELECT price FROM (SELECT * FROM f15_screensroom sc JOIN f15_movieschedule ms ON sc.id=ms.screeningroomno) a WHERE a.movieid =" + m + " and a.theatreid=" + t;
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
//            ps.setInt(1, m);
//            ps.setInt(2, t);
//            ResultSet res = ps.executeQuery();

            if (res.next()) {
                price = res.getDouble(1);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return price;
    }

}
