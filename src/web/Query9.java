package web;

import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by EYlee on 11/27/15.
 */
public class Query9 {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        Statement st = null;
        try {
            String sql = "select * from f15_enrollment where to_char(workingtimestart,'yyyy-mm-dd')=to_char(sysdate+1,'yyyy-mm-dd') and THEATREID=3 and JOB='Security'";
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
//            if (!res.next()){
//                System.out.println("There is no security tomorrow");
//            }
            boolean flag = res.next();
            // System.out.println(flag);
            if (flag) {

                String employee = res.getString("employee");
                String job = res.getString("job");
                //String theatreid = res.getString("theatr")
                String theatreid = res.getString("theatreid");
                Time time = res.getTime("workingtimestart");
                Date date = res.getDate("workingtimestart");

                Time timee = res.getTime("workingtimeend");
                Date datee = res.getDate("workingtimeend");


                SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm:ss");

                String thetime = sdftime.format(time);
                String thedate = sdfdate.format(date);


                String thetimee = sdftime.format(timee);
                String thedatee = sdfdate.format(datee);


                String finaltime = thedate + " " + thetime;
                String finaltimee = thedatee + " " + thetimee;

//            if (employee){
//                System.out.println("There is no security tomorrow");
//            }
                System.out.println("Enployee: " + employee + ", job: " + job + ",theatreID: " + theatreid + ",workingtimestart: " + finaltime + ",workingtimeend: " + finaltimee);
            } else {
                System.out.println("There is no security tomorrow");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
