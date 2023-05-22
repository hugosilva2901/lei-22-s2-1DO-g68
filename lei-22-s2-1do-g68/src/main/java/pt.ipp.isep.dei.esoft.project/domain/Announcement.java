package pt.ipp.isep.dei.esoft.project.domain;

public class Announcement {
    private int valueOfProperty;
    private Property property;

    private EmployeeProject employeeProject;

    public Announcement(Property property, int valueOfProperty,EmployeeProject employeeProject) {
        this.property = property;
        this.valueOfProperty = valueOfProperty;
        this.employeeProject = employeeProject;
    }

    public int getValueOfProperty() {
        return valueOfProperty;
    }


    public Property getProperty(){
        return this.property;
    }

    public void setCommission(int valueOfProperty) {
        this.valueOfProperty = valueOfProperty;
    }


    public EmployeeProject getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProject employeeProject) {
        this.employeeProject = employeeProject;
    }

    public void validateAnnouncement(Announcement announcement){
        if(announcement.valueOfProperty <= 0){
            throw new IllegalArgumentException("The value Of Property is not valid");
        }

        if(announcement.property == null){
            throw new IllegalArgumentException("The Property is not valid");
        }

    }

    @Override
    public String toString() {
        return "Announcement{" +
                "value Of Property=" + valueOfProperty +
                ", property=" + property.toString() +
                '}';
    }
}
