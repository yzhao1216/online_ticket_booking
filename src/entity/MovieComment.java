package entity;

/**
 * Created by EYlee on 11/26/15.
 */
public class MovieComment {
    private int commentid;
    private String commenttext;
    private String commenttime;
    private int userid;
    private int threadid;

    public int getCommentid() {
        return commentid;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public int getUserid() {
        return userid;
    }

    public int getThreadid() {
        return threadid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setThreadid(int threadid) {
        this.threadid = threadid;
    }

    @Override
    public String toString() {
        return commentid+","+commenttime+","+userid+","+threadid+","+commenttext;
    }
}
