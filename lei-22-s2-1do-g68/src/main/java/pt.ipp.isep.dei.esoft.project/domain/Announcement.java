package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDateTime;

public class Announcement {
    private int valueOfProperty;
    private Property property;
    private EmployeeProject employeeProject;
    private AnnouncementState announcementState;
    private LocalDateTime creationDate;

    public Announcement(Property property, int valueOfProperty, EmployeeProject employeeProject) {
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

    public void validateAnnouncement(Announcement announcement) {
        if (announcement.valueOfProperty <= 0) {
            throw new IllegalArgumentException("The value Of Property is not valid");
        }

        if (announcement.property == null) {
            throw new IllegalArgumentException("The Property is not valid");
        }
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "valueOfProperty=" + valueOfProperty +
                ", property=" + property.toString() +
                ", announcementState=" + announcementState +
                ", creationDate=" + creationDate +
                '}';
    }
}
