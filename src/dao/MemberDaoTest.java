package dao;

import entity.Member;

import java.sql.SQLException;

/**
 * Created by EYlee on 11/11/15.
 */
public class MemberDaoTest{
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();

        try {
            Member m = dao.findByid(1);
            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
