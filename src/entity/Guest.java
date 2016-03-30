package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Guest {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String theatre;
    private int creditCardNum;

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

    public String getTheatre() {
        return theatre;
    }

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    @Override
    public String toString() {
        return id+","+name+","+phone+","+address+","+theatre+","+creditCardNum;
    }
}
