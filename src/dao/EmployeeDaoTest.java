package dao;

import entity.Employee;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by EYlee on 11/10/15.
 */
public class EmployeeDaoTest {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("input id");
        String line = scan.nextLine();


        //String employee = line;
        EmployeeDao dao = new EmployeeDao();
        Employee e = null;
        try {
            e = dao.findByid(line);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


//        System.out.println(e);
//        System.out.println("set employer: ");
//        line = scan.nextLine();
//        String employer = line;

        System.out.println("set theater id: ");
        int id = scan.nextInt();
        int theater_id = id;

        // System.out.println(theater_id);
        scan.nextLine();
        System.out.println("set job: ");
       // System.out.println(scan.nextLine());
        String jjob = scan.nextLine();
        String job = jjob;




        try {
//            e.setEmployee(employee);
          //  e.setEmployer(employer);
            e.setTheatreid(theater_id);
            e.setJob(job);
         //   e.setWorkingtimestart(start);
          //  e.setWorkingtimeend(end);


            //System.out.println(e);


            //dao.modify(e);
            System.out.println(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }
}
