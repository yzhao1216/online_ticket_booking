package dao;

import entity.Contribution;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EYlee on 11/11/15.
 */
public class ContributionDao {

    public void modify(Contribution c) throws SQLException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE f15_contribution SET POSTREVIEWPOINT=? WHERE id=?");
            ps.setInt(1, c.getPostreviewpoint());
            ps.setInt(2, c.getId());

            ps.executeUpdate();

        } catch (SQLException e1) {
            e1.printStackTrace();
            throw e1;
        } finally {
            DBUtil.close(con);
        }
    }


    public Contribution findByID(int anid) throws SQLException {

        Connection con = null;
        Contribution c = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM f15_Contribution WHERE id=?");
            ps.setInt(1, anid);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                int review = res.getInt("POSTREVIEWPOINT");
                int ticket = res.getInt("BUYTICKEYPOINT");

                c = new Contribution();
                c.setId(id);
                c.setPostreviewpoint(review);
                c.setBuyticketpoint(ticket);

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            throw e1;
        } finally {
            DBUtil.close(con);
        }

        return c;

    }

}
