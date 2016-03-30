package dao;

import entity.Creditcard;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/13/15.
 */
public class CreditCardDao {
    public void save(Creditcard c) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            System.out.println(con);
            Statement st = con.createStatement();
            String sql = "INSERT INTO f15_creditcard VALUES ('" + c.getCreditcardnum() + "','" + c.getCredittype() + "',TO_DATE('" + c.getExpirationdate() + "','MM/YYYY')," + c.getBalance() + ")";
            System.out.println(sql);
            st.execute(sql);


        } catch (SQLException e1) {
            e1.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }
}
