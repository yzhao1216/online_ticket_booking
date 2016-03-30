package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class MovieSchedule {
    private int id;
    private int movieID;
    private int screeningRoomNo;
    private double price;
    private String time;

    public int getId() {
        return id;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getScreeningRoomNo() {
        return screeningRoomNo;
    }

    public double getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setScreeningRoomNo(int screeningRoomNo) {
        this.screeningRoomNo = screeningRoomNo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id+","+movieID+","+screeningRoomNo+","+price+","+time;
    }
}
