package entity;

/**
 * Created by EYlee on 11/11/15.
 */
public class Contribution {
    int id;
    int postreviewpoint;
    int buyticketpoint;

    public int getId() {
        return id;
    }

    public int getPostreviewpoint() {
        return postreviewpoint;
    }

    public int getBuyticketpoint() {
        return buyticketpoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostreviewpoint(int postreviewpoint) {
        this.postreviewpoint = postreviewpoint;
    }

    public void setBuyticketpoint(int buyticketpoint) {
        this.buyticketpoint = buyticketpoint;
    }

    @Override
    public String toString() {
        return id+","+postreviewpoint+","+buyticketpoint;
    }
}
