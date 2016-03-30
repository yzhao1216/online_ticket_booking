package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Stuff {
    private int ssn;
    private int uid;

    public int getSsn() {
        return ssn;
    }

    public int getUid() {
        return uid;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return ssn + "," + uid;
    }
}
