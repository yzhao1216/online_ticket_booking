package web;

import dao.ContributionDao;
import dao.MemberDao;
import entity.Contribution;
import entity.Member;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by EYlee on 11/11/15.
 */
public class Problem5 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        ContributionDao cdao = new ContributionDao();
        System.out.println("Input the id of the user that you want to set the credit point to :");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        String status = "";
        try {
            Member m = dao.findByid(id);

            int point = m.getCreditpoint();
            if (point > 0 && point < 4) {
                status = "SILVER";
            } else if (point >= 4 && point < 8) {
                status = "GOLD";
            } else {
                status = "PLATINUM";
            }
            System.out.println("The user has:" + m.getCreditpoint() + " point, he is a " + status + " member");

            if (status == "SILVER") {
                System.out.println("Input the credit per review:(1-3 point)");
                int credit = scan.nextInt();
                while (credit > 3) {
                    System.out.println("invalid input, credit should between 1-3");
                    credit = scan.nextInt();
                }
                Contribution c = cdao.findByID(m.getId());
                c.setPostreviewpoint(credit);
                cdao.modify(c);

            } else if (status == "GOLD") {
                System.out.println("Input the credit per review:(4-8 point)");
                int credit = scan.nextInt();
                while (credit > 8 || credit < 4) {
                    System.out.println("invalid input, credit should between 4-8");
                    credit = scan.nextInt();
                }
                Contribution c = cdao.findByID(m.getId());
                c.setPostreviewpoint(credit);
                cdao.modify(c);
            } else {
                System.out.println("Input the credit per review:(great than 8 point)");
                int credit = scan.nextInt();
                while (credit < 8) {
                    System.out.println("invalid input, credit should great than 8");
                    credit = scan.nextInt();
                }
                Contribution c = cdao.findByID(m.getId());
                c.setPostreviewpoint(credit);
                cdao.modify(c);

            }
            System.out.println("update successful!");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
