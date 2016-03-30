package entity;

import java.util.Date;

/**
 * Created by EYlee on 11/10/15.
 */
public class Employee {
    private int employee;
    //private String employer;
    private int theatreid;
    private String job;
    private String workingtimestart;
    private String workingtimeend;
    private String password;

    public void setEmployee(int employee) {
        this.employee = employee;
    }

//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }

    public void setTheatreid(int theatreid) {
        this.theatreid = theatreid;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setWorkingtimestart(String workingtimestart) {
        this.workingtimestart = workingtimestart;
    }

    public void setWorkingtimeend(String workingtimeend) {
        this.workingtimeend = workingtimeend;
    }

    public int getEmployee() {
        return employee;
    }

//    public String getEmployer() {
//        return employer;
//    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTheatreid() {
        return theatreid;
    }

    public String getJob() {
        return job;
    }

    public String getWorkingtimestart() {
        return workingtimestart;
    }

    public String getWorkingtimeend() {
        return workingtimeend;
    }
    @Override
    public String toString(){
        return employee+","+theatreid+","+job+","+workingtimestart+","+workingtimeend;
    }


}
