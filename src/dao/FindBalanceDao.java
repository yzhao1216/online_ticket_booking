package dao;

import entity.MemberInfo;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/25/15.
 */
public class FindBalanceDao {
    public double findBalance(int uid) {
        Connection con = null;
        //Member m = null;

        double balance = 0;
        try {

            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from f15_member m, F15_creditcard c where c.creditcardnum = m.creditcardnum and userid =" + uid;
//            PreparedStatement ps = con.prepareStatement("SELECT ID,CREDITPOINT FROM f15_Member where NAME = ?");
//            ps.setString(1, aName);
            ResultSet res = st.executeQuery(sql);

            if (res.next()) {
                balance = res.getDouble("balance");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return balance;
    }
}
