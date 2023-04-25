package pt.ipp.isep.dei.esoft.project.domain;

public class Announcement {
    private int commission;

    public void Announcement(Property property, int commission, EmployeeProject employee){
        this.commission = commission;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
