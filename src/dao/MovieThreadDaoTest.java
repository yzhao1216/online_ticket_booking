package dao;

import entity.MovieThread;

import java.util.Date;

/**
 * Created by EYlee on 11/26/15.
 */
public class MovieThreadDaoTest {

    public static void main(String[] args) {

        MovieThreadDao dao = new MovieThreadDao();
        MovieThread mt = new MovieThread();
        mt.setMovieID(1);
        mt.setRating(1);
        mt.setUid(1);
        mt.setContent("sdfas");
        String day = "01";
        String year = "1990";
        String month = "01";
        String date =day+"/"+ month + "/" + year+" "+"12:21:12";
        mt.setTime(date);
        System.out.println(dao.saveThread(mt));
    }

}
