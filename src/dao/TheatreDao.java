package dao;

import entity.Employee;
import entity.Movie;
import entity.Theater;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/25/15.
 */
public class TheatreDao {
    public Theater findById(int id) throws Exception{
        Theater t = null;
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM f15_Theatre WHERE id = ?");
            ps.setInt(1, id);
            res = ps.executeQuery();
            // System.out.println(res.getString(1));
            if (res.next()) {
                int anid = res.getInt("id");
                //String er = res.getString("EMPLOYER");
                String address = res.getString("address");
                int count = res.getInt("");
                t = new Theater();
                t.setId(anid);
                //e.setEmployer(er);
                t.setAddress(address);
                t.setTicketCount(t.getTicketCount());
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return t;
    }
    public void modify(int th) throws SQLException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            //the manager will be able to find a employee that he wants to
            // modify,then he can set his working theatre's id
            //job,working time start and working time end;
            String sql = "UPDATE f15_theatre set ticketcount = ticketcount +1 where id ="+th+"";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("********");


//
        } catch (SQLException e1) {
            e1.printStackTrace();

        } finally {
            DBUtil.close(con);
        }}
    public List<Theater> findAll() throws Exception {
        List<Theater> theaters = new ArrayList<Theater>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "Select * from f15_theatre";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                int anid = res.getInt("id");
                String address = res.getString("address");
                int ticketcount = res.getInt("ticketcount");
                Theater t = new Theater();
                t.setId(anid);
                t.setAddress(address);
                t.setTicketCount(ticketcount);
                theaters.add(t);
                System.out.println(t.getTicketCount());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return theaters;
    }
}
