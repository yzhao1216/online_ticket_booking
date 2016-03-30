package web;

/**
 * Created by EYlee on 11/11/15.
 */

import dao.EmployeeDao;
import dao.StuffDao;
import dao.UserDao;
import entity.Employee;

import java.sql.SQLException;
import java.util.Scanner;


import entity.Employee;
import entity.Stuff;
import entity.User;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by EYlee on 11/10/15.
 */
public class Problem4 {
    //        @Test
//    public void testfind() throws SQLException{
//        EmployeeDao dao = new EmployeeDao();
//        Employee e = dao.findByid("123456781");
//        System.out.println(e);
//    }

    public static void run1() throws SQLException{
        Scanner scan = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDao();
        Employee e = new Employee();
        Stuff s = new Stuff();
        StuffDao s_dao = new StuffDao();


        //save to user
        UserDao u_dao = new UserDao();
        User u = new User();

        System.out.println("Input stuff name: ");
        String name = scan.nextLine();
        u.setName(name);

        System.out.println("input phone number: ");
        String phone = scan.nextLine();
        u.setPhone(phone);

        System.out.println("input address: ");
        String address = scan.nextLine();
        u.setAddress(address);

        System.out.println("input password: ");
        String password = scan.nextLine();
        u.setPassword(password);

        u_dao.save(u);

        //save to staff
        System.out.println("SSN: ");
        int staffssn = scan.nextInt();
        s.setSsn(staffssn);
        s_dao.save(s,u);
        System.out.println("Success");

        //save to enrollment




//        System.out.println("SSN: ");
//        int ssn = scan.nextInt();

        e.setEmployee(s.getSsn());

        System.out.println("Theatre id: ");
        int id = scan.nextInt();
        e.setTheatreid(id);

        scan.nextLine();
        System.out.println("Job: ");
        String job = scan.nextLine();
        e.setJob(job);

        System.out.println("start: ");
        String start = scan.nextLine();
        e.setWorkingtimestart(start);

        System.out.println("end: ");
        String end = scan.nextLine();
        e.setWorkingtimeend(end);

        dao.save(e);
        System.out.println("Save success");

    }

    public static void run2() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("input id");
        String line = scan.nextLine();


        //String employee = line;
        EmployeeDao dao = new EmployeeDao();

        Employee e = null;
        try {
            e = dao.findByid(line);
            System.out.println(e);
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

        System.out.println("set start: ");

//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        line = scan.nextLine();
        String start = line;

        System.out.println("Set end: ");
        line = scan.nextLine();
        String end = line;

        try {
            //e.setEmployee(employee);
            //e.setEmployer(employer);
            e.setTheatreid(theater_id);
            e.setJob(job);
            e.setWorkingtimestart(start);
            e.setWorkingtimeend(end);


            //System.out.println(e);


            dao.modify(e);
            System.out.println("Update done");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Set---1, Update---2,exit:-1");
        int n = scan.nextInt();
        while (n != -1) {
            if (n == 1) {
                try {
                    run1();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            } else if (n == 2) {
                try {
                    run2();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("Wrong input, input again");
                n = scan.nextInt();
            }

        }
        System.out.println("Bye");


    }
}

