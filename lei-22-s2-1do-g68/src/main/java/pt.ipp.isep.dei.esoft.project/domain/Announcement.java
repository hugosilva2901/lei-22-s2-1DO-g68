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

    public void validateAnnouncement(Announcement announcement){
        if(announcement.commission <= 0){
            throw new IllegalArgumentException("The commission is not valid");
        }

        if(announcement.property == null){
            throw new IllegalArgumentException("The Property is not valid");
        }

    }
}
