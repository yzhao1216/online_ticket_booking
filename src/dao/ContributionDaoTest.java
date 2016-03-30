package dao;

import entity.Contribution;
import entity.Member;

import java.sql.SQLException;

/**
 * Created by EYlee on 11/11/15.
 */
public class ContributionDaoTest {
    public static void main(String[] args) {
        ContributionDao dao = new ContributionDao();
        try {
            Contribution c = dao.findByID(1);
            System.out.println(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
