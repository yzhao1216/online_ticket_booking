package dao;

import entity.MovieThread;
import entity.TheatreThread;
import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 12/9/15.
 */
public class TheatreThreadDao {
    public boolean saveThread(TheatreThread tt) {
        Connection con = DBUtil.getConnection();

        String sql = "insert into f15_theatrereview values(thread_id.NEXTVAL," + tt.getTheatreID() + "," +tt.getMemberID() + ",'" + tt.getRating() + "','"+tt.getContent()+"',sysdate)";
        System.out.println(sql);
        try {

            Statement st = con.createStatement();
            int isok = st.executeUpdate(sql);
            if (isok > 0) {
                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }

        return true;
    }

    public List<MovieThread> findAll() {
        Connection con = DBUtil.getConnection();
        String sql = "select * from f15_moviereview";

        Statement st = null;

        List<MovieThread> threadList = new ArrayList<MovieThread>();

        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id = res.getString("id");
                String movieid = res.getString("movieid");
                String rate = res.getString("rating");
                String content = res.getString("content");
                Date date = res.getDate("time");
                Time time = res.getTime("time");
                String userid = res.getString("userid");
                System.out.println(time);
                //change time format to string
                SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm:ss");
                SimpleDateFormat sdfdate = new SimpleDateFormat("YYYY-MM-DD");

                String time1 = sdftime.format(time);
                String date1 = sdfdate.format(date);
                String finaltime = date1+" "+time1;
                System.out.println(time1);

                MovieThread mt = new MovieThread();

                mt.setId(Integer.parseInt(id));
                mt.setMovieID(Integer.parseInt(movieid));
                mt.setRating(Integer.parseInt(rate));
                mt.setContent(content);
                mt.setTime(finaltime);
                mt.setUid(Integer.parseInt(userid));

                threadList.add(mt);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return threadList;
    }
}
