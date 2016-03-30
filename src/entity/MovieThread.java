package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class MovieThread {
    private int id;
    private int movieID;
    private int uid;
    private int rating;
    private String content;
    private String time;

    public int getId() {
        return id;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getUid() {
        return uid;
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

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
        return id+","+movieID+","+uid+","+rating+","+content+","+time;
    }
}
