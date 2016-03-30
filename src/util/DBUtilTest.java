package util;

import java.sql.Connection;

/**
 * Created by EYlee on 11/13/15.
 */
public class DBUtilTest {
    public static void main(String[] args) {
        Connection con = null;
        DBUtil.getConnection();
        System.out.println("Con..");

    }
}
