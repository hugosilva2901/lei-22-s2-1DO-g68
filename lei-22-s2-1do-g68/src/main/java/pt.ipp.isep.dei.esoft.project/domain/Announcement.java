package pt.ipp.isep.dei.esoft.project.domain;

public class Announcement {
    private int commission;
    private Property property;
    private EmployeeProject employee;

    public Announcement(Property property, int commission, EmployeeProject employee){
        this.property = property;
        this.commission = commission;
        this.employee = employee;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
