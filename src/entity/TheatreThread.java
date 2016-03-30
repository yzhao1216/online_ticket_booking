package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class TheatreThread {
    private int id;
    private int theatreID;
    private int memberID;
    private int rating;
    private String content;
    private String time;

    public int getId() {
        return id;
    }

    public int getTheatreID() {
        return theatreID;
    }

    public int getMemberID() {
        return memberID;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return id+","+theatreID+","+memberID+","+rating+","+content+","+time;
    }
}
