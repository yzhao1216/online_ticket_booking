package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Membershipstatus {
    private int creditpoint;
    private String status;

    public int getCreditpoint() {
        return creditpoint;
    }

    public String getStatus() {
        return status;
    }

    public void setCreditpoint(int creditpoint) {
        this.creditpoint = creditpoint;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return creditpoint+","+status;
    }
}

