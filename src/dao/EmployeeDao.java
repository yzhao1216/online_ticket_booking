package dao;

import entity.Employee;
import entity.Staff;

import util.DBUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/10/15.
 */
public class EmployeeDao {

    public void delete(Employee e) throws SQLException {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "Delete from f15_ENROLLMENT where employee=" + e.getEmployee();
            st.executeUpdate(sql);
//            PreparedStatement ps = con.prepareStatement("DELETE FROM f15_enrollment WHERE employee=?");
//            ps.setInt(1, id);
//            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw e1;
        } finally {
            DBUtil.close(con);
        }

    }

    public List<Employee> findAll() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "Select * from f15_enrollment";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                int employee = res.getInt("employee");
                int theatreID = res.getInt("theatreid");
                String job = res.getString("job");
                String WORKINGTIMESTART = res.getString("WORKINGTIMESTART");
                String WORKINGTIMEEND = res.getString("WORKINGTIMEEND");
                Employee e = new Employee();
                e.setEmployee(employee);
                e.setTheatreid(theatreID);
                e.setJob(job);
                e.setWorkingtimestart(WORKINGTIMESTART);
                e.setWorkingtimeend(WORKINGTIMEEND);
                employees.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return employees;
    }




    public void save(Employee e) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO f15_ENROLLMENT VALUES(" + e.getEmployee() + "," + e.getTheatreid() + ",'" + e.getJob() + "',TO_DATE('" + e.getWorkingtimestart() + "','HH24:MI:SS'),TO_DATE('" + e.getWorkingtimeend() + "','HH24:MI:SS'),'" + e.getPassword() + "')";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("********");


        } catch (SQLException e1) {
            e1.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }

    public Employee findByid(String anid) throws SQLException {
        Connection con = null;
        Employee e = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM f15_ENROLLMENT WHERE EMPLOYEE = ?");
            ps.setString(1, anid);
            ResultSet res = ps.executeQuery();
            // System.out.println(res.getString(1));
            if (res.next()) {
                int ee = res.getInt("EMPLOYEE");
                //String er = res.getString("EMPLOYER");
                int thea_id = res.getInt("THEATREID");
                String job = res.getString("JOB");
                String start = res.getString("WORKINGTIMESTART");
                String end = res.getString("WORKINGTIMEEND");
                e = new Employee();
                e.setEmployee(ee);
                //e.setEmployer(er);
                e.setTheatreid(thea_id);
                e.setJob(job);
                e.setWorkingtimestart(start);
                e.setWorkingtimeend(end);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(con);
        }


        return e;
    }

    //modify method
    public void modify(Employee e) throws SQLException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            //the manager will be able to find a employee that he wants to
            // modify,then he can set his working theatre's id
            //job,working time start and working time end;
            String sql = "UPDATE f15_ENROLLMENT SET THEATREID = " + e.getTheatreid() + ",JOB='" + e.getJob() + "',WORKINGTIMESTART=TO_DATE('" + e.getWorkingtimestart() + "','HH24:MI:SS'),WORKINGTIMEEND=TO_DATE('" + e.getWorkingtimeend() + "','HH24:MI:SS') WHERE employee=" + e.getEmployee();
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


}
