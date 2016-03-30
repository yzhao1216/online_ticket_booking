package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class ScreensRoom {
    private int id;
    private int theatreID;
    private int roomNum;
    private int capacity;

    public int getId() {
        return id;
    }

    public int getTheatreID() {
        return theatreID;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return id+","+theatreID+","+roomNum+","+capacity;
    }
}
