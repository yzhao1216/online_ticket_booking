package dao;

import entity.Movie;

import java.sql.SQLException;

/**
 * Created by EYlee on 11/25/15.
 */
public class MovieDaoTest {
    public static void main(String[] args) {
        MovieDao dao = new MovieDao();
        Movie m = new Movie();
        m.setId(1);
        m.setTitle("000");
        m.setDirector("ddddd");
        m.setDescription("dddfa");
        try {
            dao.modify(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
