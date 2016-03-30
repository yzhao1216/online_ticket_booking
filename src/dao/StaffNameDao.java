package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 12/1/15.
 */
public class StaffNameDao {
    public List<String> findAllJob(String name) {
        Connection con = null;
        con = DBUtil.getConnection();
        String sql = "select job from f15_enrollment where name='" + name + "'";
        System.out.println(sql);
        List<String> list = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("job"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }

    public List<String> findAllName() {
        Connection con = null;
        con = DBUtil.getConnection();
        String sql = "select name from (select * from f15_user where id in(select userid from (select * from f15_staff where ssn in(select employee from f15_enrollment))))";
        System.out.println(sql);
        List<String> list = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
