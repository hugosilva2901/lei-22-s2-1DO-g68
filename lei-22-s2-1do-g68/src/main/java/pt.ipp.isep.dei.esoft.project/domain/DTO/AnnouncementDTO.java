package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Property;

public class AnnouncementDTO {
    private int valueOfProperty;
    private Property property;
    private EmployeeProjectDTO employeeProject;

    public AnnouncementDTO(Property property, int valueOfProperty, EmployeeProjectDTO employeeProject) {
        this.property = property;
        this.valueOfProperty = valueOfProperty;
        this.employeeProject = employeeProject;
    }

    public int getValueOfProperty() {
        return valueOfProperty;
    }

    public void setValueOfProperty(int valueOfProperty) {
        this.valueOfProperty = valueOfProperty;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public EmployeeProjectDTO getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProjectDTO employeeProject) {
        this.employeeProject = employeeProject;
    }

    @Override
    public String toString() {
        return "AnnouncementDTO{" +
                "valueOfProperty=" + valueOfProperty +
                ", property=" + property +
                ", employeeProject=" + employeeProject +
                '}';
    }
}
