package entity;

/**
 * Created by EYlee on 11/11/15.
 */
public class Member {

    private int userid;
    private String password;
    private String email;
    private String creditcardnum;
    private int creditpoint;
    private String phone;
    private String address;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditcardnum() {
        return creditcardnum;
    }

    public int getCreditpoint() {
        return creditpoint;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum;
    }

    public void setCreditpoint(int creditpoint) {
        this.creditpoint = creditpoint;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return userid+","+email+","+creditcardnum+","+creditpoint+","+phone+","+address;
    }


}
