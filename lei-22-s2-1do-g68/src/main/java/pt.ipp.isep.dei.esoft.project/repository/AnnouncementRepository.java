package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.EmployeeProjectMapper;

import java.util.*;
import java.util.stream.Collectors;

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

    public Optional<Announcement> createAnnouncement(Property property, int valueOfProperty, EmployeeProject employeeProject) {
        Announcement announcement = new Announcement(property, valueOfProperty, employeeProject);
        announcements.add(announcement);
        return Optional.of(announcement);
    }

    public List<AnnouncementDTO> getAnnouncementsByEmployee(EmployeeProjectDTO employeeProject) {
        List<AnnouncementDTO> announcementsByEmployee = new ArrayList<>();
        for (Announcement a : announcements) {
            if (a.getEmployeeProject().equals(EmployeeProjectMapper.toEntity(employeeProject))) {
                announcementsByEmployee.add(AnnouncementMapper.toDTO(a));
            }
        }
        return announcementsByEmployee;
    }
    public List<AnnouncementDTO> getAnnouncementsDTO() {
        return announcements.stream()
                .map(AnnouncementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AnnouncementDTO> getPendingAnnouncementsByDate(String employeeProject) {
        return announcements.stream()
                .filter(a -> a.getEmployeeProject().getEmail().equals(employeeProject))
                .filter(a -> a.getAnnouncementState() == AnnouncementState.PENDING)
                .sorted(Comparator.comparing(Announcement::getCreationDate).reversed())
                .map(AnnouncementMapper::toDTO)
                .collect(Collectors.toList());
    }


}
