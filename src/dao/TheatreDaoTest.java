package dao;

import entity.Theater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYlee on 11/25/15.
 */
public class TheatreDaoTest {

    public static void main(String[] args) {
        TheatreDao dao = new TheatreDao();
        List<Theater> theaters = new ArrayList<Theater>();

        try {
            theaters = dao.findAll();
            System.out.println(theaters.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
