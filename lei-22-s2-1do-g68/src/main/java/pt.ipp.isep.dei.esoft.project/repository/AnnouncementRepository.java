package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

    public Optional<Announcement>  createAnnouncement(Property property, int commission,EmployeeProject employeeProject) {
        Optional<Announcement> optionalValue = Optional.empty();
        Announcement announcement = new Announcement(property, commission,employeeProject);
        optionalValue = Optional.of(announcement);
        addAnnouncement(announcement);
        return optionalValue;
    }

    public List<Announcement> getAnnouncementsByEmployee(EmployeeProject employeeProject) {
        List<Announcement> announcementsByEmployee = new ArrayList<>();
        for (Announcement a : announcements) {
            if (a.getEmployeeProject().equals(employeeProject)) {
                announcementsByEmployee.add(a);
            }
        }
        return announcementsByEmployee;
    }

}
