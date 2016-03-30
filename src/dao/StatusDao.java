package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EYlee on 11/26/15.
 */
public class StatusDao {
    public int findConmment(int userid) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select count(*) as count from f15_moviecomment where userid = " + userid;
        System.out.println(sql);
        int countComment = 0;
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                countComment = res.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countComment;
    }

    public int findThread(int userid) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select count(*) as count from f15_moviereview where userid = " + userid;
        System.out.println(sql);
        int countreview = 0;
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                countreview = res.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countreview;


    }

    public String findStatus(int credipoint) {

        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "select status from f15_membershipstatus where creditpoint = " + credipoint;
        System.out.println(sql);
        String status = "";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                status = res.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;


    }

    public void addCreditBuyticket(int userid) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "update f15_member set creditpoint = creditpoint+1 where userid = " + userid;
        System.out.println(sql);

        try {
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Update success");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void decreaseBalance(int userid, double num) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "update F15_CREDITCARD set BALANCE =balance- " + num + " where CREDITCARDNUM=(select creditcardnum from F15_member where userid="+userid+")";
        System.out.println(sql);

        try {
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Update success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCreditPost(int userid, int creditpoint) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        String sql = "update f15_member set creditpoint = " + creditpoint + " where userid = " + userid;
        System.out.println(sql);

        try {
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Update success");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
