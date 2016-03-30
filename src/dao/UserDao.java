package dao;

import entity.Employee;
import entity.Member;
import entity.User;
import util.DBUtil;

import java.sql.*;

/**
 * Created by EYlee on 11/12/15.
 */
public class UserDao {

    public void modify(User u) throws SQLException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            //the manager will be able to find a employee that he wants to
            // modify,then he can set his working theatre's id
            //job,working time start and working time end;
            String sql = "UPDATE f15_user SET NAME = '" + u.getName()+ "',PHONE='" + u.getPhone() + "',address='" + u.getAddress() + "',password='" + u.getPassword() + "' WHERE id=" + u.getId();
            System.out.println(sql);
            st.execute(sql);
            System.out.println("********");
//

        } catch (SQLException e1) {
            e1.printStackTrace();

        } finally {
            DBUtil.close(con);
        }

    }


    public User findByid(String anid) throws SQLException {
        Connection con = null;
        User u = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM f15_user WHERE id = ?");
            ps.setString(1, anid);
            ResultSet res = ps.executeQuery();
            // System.out.println(res.getString(1));
            if (res.next()) {
                int id = res.getInt("id");
                //String er = res.getString("EMPLOYER");
                String name = res.getString("name");
                String phone = res.getString("phone");
                String address = res.getString("address");
                String password = res.getString("password");
                u = new User();
                u.setId(id);
                u.setName(name);
                u.setPhone(phone);
                u.setAddress(address);
                u.setPassword(password);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return u;
    }

    public int findID(User u) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select id from f15_user where phone ='"+u.getPhone()+"'";
            ResultSet res = st.executeQuery(sql);
            if (res.next()){
                int id = res.getInt("ID");
                u.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }

        return u.getId();

    }

    public void save(User u) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();

            String sql = "INSERT INTO f15_user VALUES(user_id.NEXTVAL,'" + u.getName() + "','" + u.getPhone() + "','" + u.getAddress() + "','" + u.getPassword() + "')";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("********");

        } catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }
}
