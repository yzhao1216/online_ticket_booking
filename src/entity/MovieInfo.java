package entity;

/**
 * Created by EYlee on 11/26/15.
 */
public class MovieInfo {
    private int id;
    private String title;
    private String time;
    private int price;
    private String director;
    private String description;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
