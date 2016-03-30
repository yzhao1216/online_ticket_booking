package dao;

import entity.User;

/**
 * Created by EYlee on 11/12/15.
 */
public class UserDaoTest {


    public void testsave(){
        UserDao dao = new UserDao();
        User u = new User();
        u.setName("asdf");
        u.setPhone("3125667");
        u.setAddress("sd");
        u.setPassword("1234");
        dao.save(u);
        System.out.println("Success");
    }
}
