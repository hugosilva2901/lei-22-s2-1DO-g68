package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public boolean removeAnnouncement (Announcement announcement) {
        return announcements.remove(announcement);
    }

    public void createAnnouncement(Property property, int commission, EmployeeProject employee) {
        Announcement announcement = new Announcement(property, commission, employee);
        addAnnouncement(announcement);
    }

}
