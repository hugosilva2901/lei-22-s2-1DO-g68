package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.EmployeeProjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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

    public Optional<Announcement>  createAnnouncement(Property property, int commission,EmployeeProjectDTO employeeProject) {
        EmployeeProject employeeProject1 = EmployeeProjectMapper.toEntity(employeeProject) ;
        Optional<Announcement> optionalValue = Optional.empty();
        Announcement announcement = new Announcement(property, commission,employeeProject1);
        optionalValue = Optional.of(announcement);
        addAnnouncement(announcement);
        return optionalValue;
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

}
