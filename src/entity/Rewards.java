package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Rewards {
    private String name;
    private int worthPoint;

    public String getName() {
        return name;
    }

    public int getWorthPoint() {
        return worthPoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorthPoint(int worthPoint) {
        this.worthPoint = worthPoint;
    }

    @Override
    public String toString() {
        return name+","+worthPoint;
    }
}
