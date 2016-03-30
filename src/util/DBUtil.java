package util;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by EYlee on 11/8/15.
 */
public class DBUtil {

    public static Connection getConnection(){
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","yzhao91","YCsBUo3...uK3Y15");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","sye7","1617273107");


        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }

    public static void close(Connection con){

        try {
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
        System.out.println("connection success");

    }

}
