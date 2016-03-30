package entity;

/**
 * Created by EYlee on 11/14/15.
 */
public class Member6 {
    private int userid;
    private String password;
    private String email;
    private String cardNum;
    private int creditPoint;
    private String phone;
    private String address;

    public Member6(){
        creditPoint = 1;
    }
    public int getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCardNum() {
        return cardNum;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return userid+","+password+","+email+","+cardNum+","+creditPoint+","+phone+","+address;
    }
}
