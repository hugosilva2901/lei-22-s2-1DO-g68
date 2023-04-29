package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreatGuestController {
    private AuthenticationRepository authenticationRepository = null;
    private AnnouncementRepository announcementRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatGuestController() {
        getAuthenticationRepository();
        getAnnouncementRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreatGuestController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = this.authenticationRepository;
    }


    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
    public AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the PropertyRepository
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public List<Announcement> getAnnouncementsByNumberOfRooms(int numberOfRooms) {
        List<Announcement> announcements = announcementRepository.getAnnouncements();
        return announcements.stream()
                .filter(a -> {
                    Property property = a.getProperty();
                    if (property instanceof Apartment) {
                        return ((Apartment) property).getNumberOfRooms() == numberOfRooms;
                    } else if (property instanceof House) {
                        return ((House) property).getNumberOfRooms() == numberOfRooms;
                    } else if (property instanceof Land) {
                        return false;
                    } else {
                        throw new RuntimeException("Unknown property type: " + property.getClass().getName());
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Announcement> FilterPropertiesTypeChoice(String propertyType) {
        List<Announcement> announcements = announcementRepository.getAnnouncements();
        List<Announcement> filteredAnnouncements = new ArrayList<>();

        for (Announcement announcement : announcements) {
            if (announcement.getProperty().getType().equalsIgnoreCase(propertyType)) {
                filteredAnnouncements.add(announcement);
            }
        }

        if (filteredAnnouncements.isEmpty()) {
            System.out.println("No properties of the selected type were found.");
        }

        return filteredAnnouncements;
    }
}

