package entity;

/**
 * Created by EYlee on 11/13/15.
 */
public class Theater {
    private int id;
    private String address;
    private int TicketCount;

    public int getTicketCount() {
        return TicketCount;
    }

    public void setTicketCount(int ticketCount) {
        TicketCount = ticketCount;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCount(){
        TicketCount++;
    }
    @Override
    public String toString() {
        return id+","+address+","+TicketCount;
    }
}
