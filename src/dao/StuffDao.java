package dao;

import entity.Stuff;
import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by EYlee on 11/13/15.
 */
public class StuffDao {
    public void save(Stuff s, User u)throws SQLException{
        Connection con = null;
        UserDao dao = new UserDao();
        try{
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT  INTO f15_staff values(?,?)");
            ps.setInt(1,s.getSsn());
            ps.setInt(2,dao.findID(u));
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con);
        }
    }

}
