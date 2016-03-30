package entity;

import java.util.Date;

/**
 * Created by EYlee on 11/12/15.
 */
public class Creditcard {
    private String creditcardnum;
    private String credittype;
    private String expirationdate;
    private double balance;

    public String getCreditcardnum() {
        return creditcardnum;
    }

    public String getCredittype() {
        return credittype;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public double getBalance() {
        return balance;
    }

    public void setCreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum;
    }

    public void setCredittype(String credittype) {
        this.credittype = credittype;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return creditcardnum+","+credittype+","+expirationdate+","+balance;
    }
}
