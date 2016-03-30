package entity;

/**
 * Created by EYlee on 11/25/15.
 */
public class MemberInfo {
    private int id;
    private String name;
    private String phone;
    private String address;

    private String email;
    private int creditpoint;
    private String status;
    private double balance;

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }


    public String getEmail() {
        return email;
    }

    public int getCreditpoint() {
        return creditpoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditpoint(int creditpoint) {
        this.creditpoint = creditpoint;
    }
}
