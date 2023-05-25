package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.AnnouncementState;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.time.LocalDateTime;

public class AnnouncementDTO {
    private int valueOfProperty;
    private Property property;
    private EmployeeProjectDTO employeeProject;
    private AnnouncementState announcementState;
    private LocalDateTime creationDate;

    public AnnouncementDTO(Property property, int valueOfProperty, EmployeeProjectDTO employeeProject) {
        this.property = property;
        this.valueOfProperty = valueOfProperty;
        this.employeeProject = employeeProject;
        this.announcementState = AnnouncementState.PENDING;
        this.creationDate = LocalDateTime.now();
    }

    public int getValueOfProperty() {
        return valueOfProperty;
    }

    public Property getProperty() {
        return property;
    }

    public EmployeeProjectDTO getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProjectDTO employeeProject) {
        this.employeeProject = employeeProject;
    }

    public void setValueOfProperty(int valueOfProperty) {
        this.valueOfProperty = valueOfProperty;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public AnnouncementState getAnnouncementState() {
        return announcementState;
    }

    public void setAnnouncementState(AnnouncementState announcementState) {
        this.announcementState = announcementState;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "AnnouncementDTO{" +
                "valueOfProperty=" + valueOfProperty +
                ", property=" + property +
                ", employeeProject=" + employeeProject +
                ", announcementState=" + announcementState +
                ", creationDate=" + creationDate +
                '}';
    }
}
