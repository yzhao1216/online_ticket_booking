package dao;

import entity.Employee;
import entity.Rewards;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/30/15.
 */
public class RewardDao {
    public List<Rewards> findByPoint(int point) throws SQLException {
        Connection con = null;
        List<Rewards> rewardses = new ArrayList<Rewards>();

        int worthpoint = 0;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM f15_rewards WHERE worthpoint<"+point;
            System.out.println(sql);

            ResultSet res = st.executeQuery(sql);
            // System.out.println(res.getString(1));

            while (res.next()) {
                Rewards rw = new Rewards();

                rw.setName(res.getString("name"));
                rw.setWorthPoint(res.getInt("worthpoint"));

                rewardses.add(rw);
                //worthpoint = res.getInt("worthpoint");
                //String er = res.getString("EMPLOYER");

            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return rewardses;
    }
}
