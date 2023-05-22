package pt.ipp.isep.dei.esoft.project.domain;

public class order {

    private Announcement announcement;
    private int value;

    private Client client;

    private StatusOfOrder statusOfOrder;
    public order(Announcement announcement, int value,Client client) {
        this.announcement = announcement;
        this.value = value;
        this.client=client;
        this.statusOfOrder=StatusOfOrder.Pending;
    }

    public int getValue() {
        return value;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StatusOfOrder getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(StatusOfOrder statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Client getClient(){
        return this.client;

    }

    public void setClient(Client client){
        this.client=client;
    }

    public void validateOrder(order order) {
        if (order.value <= 0) {
            throw new IllegalArgumentException("The value Of Property is not valid");
        }

        if (order.announcement == null) {
            throw new IllegalArgumentException("The Property is not valid");
        }

        if (order.client == null) {
            throw new IllegalArgumentException("The Client is not valid");
        }

    }


}
