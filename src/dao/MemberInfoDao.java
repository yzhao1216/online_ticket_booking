package dao;

import entity.Employee;
import entity.MemberInfo;
import entity.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/25/15.
 */
public class MemberInfoDao {




    public User findByid(String anid) throws SQLException {
        Connection con = null;
        User e = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM f15_user WHERE id = ?");
            ps.setString(1, anid);
            ResultSet res = ps.executeQuery();
            // System.out.println(res.getString(1));
            if (res.next()) {
                int userid = res.getInt("id");
                //String er = res.getString("EMPLOYER");
                String name = res.getString("name");
                String phone = res.getString("phone");
                String address = res.getString("address");
                String password = res.getString("password");
                e = new User();
                e.setId(userid);

                e.setName(name);
                e.setPhone(phone);
                e.setAddress(address);
                e.setPassword(password);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return e;
    }
    public List<MemberInfo> findAll() throws Exception {
        List<MemberInfo> memberInfos = new ArrayList<MemberInfo>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select userid,name, phone ,address,email,creditpoint,status,balance from(select * from(select * from f15_member m natural join F15_CREDITCARD c )  natural join f15_membershipstatus s) a  join f15_user u on a.userid=u.id ";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                int userid = res.getInt("userid");
                String name = res.getString("name");
                String phone = res.getString("phone");
                String address = res.getString("address");
                String email = res.getString("email");
                String creditpoint = res.getString("creditpoint");
                String status = res.getString("status");
                String balance = res.getString("balance");
                MemberInfo minfo = new MemberInfo();
                minfo.setId(userid);
                minfo.setName(name);
                minfo.setPhone(phone);
                minfo.setAddress(address);
                minfo.setEmail(email);
                minfo.setCreditpoint(Integer.parseInt(creditpoint));
                minfo.setStatus(status);
                minfo.setBalance(Double.parseDouble(balance));
                memberInfos.add(minfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return memberInfos;
    }


    public MemberInfo findByName(String aName) throws SQLException {
        Connection con = null;
        //Member m = null;

        MemberInfo minfo = null;
        try {

            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select userid,name, phone ,address,email,creditpoint,status,balance from(select * from(select * from f15_member m natural join F15_CREDITCARD c )  natural join f15_membershipstatus s) a  join f15_user u on a.userid=u.id where name='" + aName + "'";
//            PreparedStatement ps = con.prepareStatement("SELECT ID,CREDITPOINT FROM f15_Member where NAME = ?");
//            ps.setString(1, aName);
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);

            if (res.next()) {
                int id = res.getInt("userid");
                String name = res.getString("name");
                String phone = res.getString("phone");
                String address = res.getString("address");
                String email = res.getString("email");
                int creidpoint = res.getInt("creditpoint");
                String status = res.getString("status");
                double balance = res.getDouble("balance");

                minfo = new MemberInfo();
                minfo.setId(id);
                minfo.setName(name);
                minfo.setPhone(phone);
                minfo.setAddress(address);
                minfo.setEmail(email);
                minfo.setCreditpoint(creidpoint);
                minfo.setStatus(status);
                minfo.setBalance(balance);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }

        return minfo;


    }
}
