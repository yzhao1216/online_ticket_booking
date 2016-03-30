package dao;

import entity.*;
import util.DBUtil;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by EYlee on 11/11/15.
 */
public class MemberDao {

    public void modify(MemberInfo m) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE f15_member SET email='" + m.getEmail() + "'where userid=" + m.getId() + "";
            System.out.println(sql);
            st.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }


    public void save(Member6 m, Creditcard c) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO f15_member VALUES (member_id.NEXTVAL" + ",'" + m.getUserid() + "','" + m.getEmail() + "','" + c.getCreditcardnum() + "'," + m.getCreditPoint() + ")";
            System.out.println(sql);
            st.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }


    public Member findByid(int anid) throws SQLException {
        Connection con = null;
        Member m = null;

        try {


            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT ID,CREDITPOINT FROM f15_Member where ID = ?");
            ps.setInt(1, anid);
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                int id = res.getInt("ID");
                int point = res.getInt("CREDITPOINT");

                m = new Member();

                m.setId(id);
                m.setCreditpoint(point);

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(con);
        }

        return m;
    }

}
