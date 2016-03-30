package dao;

import entity.Membershipstatus;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/13/15.
 */
public class MshipStatusDao {
    public void save() {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO f15_membershipstatus VALUES(1,'SILVER')";
            st.execute(sql);
            System.out.println("********");


        } catch (SQLException e1) {
            e1.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }
}
