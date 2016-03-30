package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class JobType {
    private String job;
    private String description;

    public String getJob() {
        return job;
    }

    public String getDescription() {
        return description;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return job+","+description;
    }
}
