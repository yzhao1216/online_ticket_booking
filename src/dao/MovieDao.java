package dao;

import entity.*;
import util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/25/15.
 */
public class MovieDao {

    public void save(Movie m) {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO f15_movie VALUES (movie_id.NEXTVAL" + ",'" + m.getTitle() + "','" + m.getDirector() + "','" + m.getDescription() + "')";
            System.out.println(sql);
            st.execute(sql);
//


        } catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        } finally {
            DBUtil.close(con);
        }

    }


    public void modifytime(MovieSchedule ms) throws SQLException{
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            //the manager will be able to find a employee that he wants to
            // modify,then he can set his working theatre's id
            //job,working time start and working time end;
            String sql = "UPDATE f15_movieschedule SET time =TO_DATE('"+ms.getTime()+"','yyyy-mm-dd hh24:mi:ss') WHERE movieid=" +ms.getMovieID();
            System.out.println(sql);
            st.execute(sql);
            System.out.println("update success");
//

        } catch (SQLException e1) {
            e1.printStackTrace();

        } finally {
            DBUtil.close(con);
        }
    }
    public void modify(Movie m) throws SQLException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            //the manager will be able to find a employee that he wants to
            // modify,then he can set his working theatre's id
            //job,working time start and working time end;
            String sql = "UPDATE f15_movie SET Title = '" + m.getTitle() + "',Director='" + m.getDirector() + "',description='" + m.getDescription() + "' WHERE id=" + m.getId();
            System.out.println(sql);
            st.execute(sql);
            System.out.println("update success");
//

        } catch (SQLException e1) {
            e1.printStackTrace();

        } finally {
            DBUtil.close(con);
        }

    }

    public Movie findById(int id) throws Exception {
        Movie m = null;
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM f15_Movie WHERE id = ?");
            ps.setInt(1, id);
            res = ps.executeQuery();
            // System.out.println(res.getString(1));
            if (res.next()) {
                int anid = res.getInt("id");
                //String er = res.getString("EMPLOYER");
                String title = res.getString("title");
                String director = res.getString("director");
                String description = res.getString("description");
                m = new Movie();
                m.setId(anid);
                //e.setEmployer(er);
                m.setTitle(title);
                m.setDirector(director);
                m.setDescription(description);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return m;
    }
    public List<Movie> findAll() throws Exception {
        List<Movie> movies = new ArrayList<Movie>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "Select * from f15_movie";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                int anid = res.getInt("id");
                String title = res.getString("title");
                String director = res.getString("director");
                String description = res.getString("description");
                Movie m = new Movie();
                m.setId(anid);
                m.setTitle(title);
                m.setDirector(director);
                m.setDescription(description);
                movies.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return movies;
    }
    public List<MovieInfo> findAllInfo(String name) throws Exception {
        List<MovieInfo> movies = new ArrayList<MovieInfo>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select movieid,title,time,price,director,description from(select * from F15_MOVIESCHEDULE where SCREENINGROOMNO in(select id from F15_SCREENSROOM where theatreid = (select theatreid from(select * from(select * from f15_user u,f15_staff s where u.ID=s.USERID) a , f15_enrollment e where a.ssn = e.employee) where name='"+name+"'))) b , F15_MOVIE m where b.movieid=m.id";
            System.out.println(sql);
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id = res.getString("movieid");
                String title = res.getString("title");
                Date date = res.getDate("time");
                Time time = res.getTime("time");
                String price = res.getString("price");
                String director = res.getString("director");
                String description = res.getString("description");

                System.out.println("&&&&&&&&&&:"+time);
                SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm:ss");
                String thetime = sdftime.format(time);
                String thedate = sdfdate.format(date);
                String finalTime = thedate+" "+thetime;
                System.out.println("&&&&&&&&&&:"+finalTime);


                MovieInfo mi = new MovieInfo();
                mi.setId(Integer.parseInt(id));
                mi.setTitle(title);
                mi.setTime(finalTime);
                mi.setPrice(Integer.parseInt(price));
                mi.setDirector(director);
                mi.setDescription(description);


                movies.add(mi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return movies;
    }
}
