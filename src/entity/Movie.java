package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Movie {
    private int id;
    private String title;
//    private String stars;
    private String director;
    private String description;
//    private char isDrama;
//    private char isAdventure;
//    private char isSci_fi;
//    private char isLoveStory;
//    private char isComedy;
//    private char isFamily;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

//    public String getStars() {
//        return stars;
//    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setStars(String stars) {
//        this.stars = stars;
//    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setIsDrama(char isDrama) {

    @Override
    public String toString() {
        return id + "," + title + "," + "," + director + "," + description;
    }
}
