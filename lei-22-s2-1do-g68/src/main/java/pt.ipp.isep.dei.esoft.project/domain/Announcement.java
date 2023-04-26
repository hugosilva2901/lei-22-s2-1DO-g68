package pt.ipp.isep.dei.esoft.project.domain;

public class Announcement {
    private int commission;
    private Property property;

    public Announcement(Property property, int commission){
        this.property = property;
        this.commission = commission;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
