package entity;

/**
 * Created by EYlee on 11/25/15.
 */
public class Staff {

    private String name;
    private String password;
    private int ssn;
    private String job;

    public String getJob() {
        return job;
    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getSsn() {
        return ssn;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return name+","+password+","+ssn+","+job;
    }
}
