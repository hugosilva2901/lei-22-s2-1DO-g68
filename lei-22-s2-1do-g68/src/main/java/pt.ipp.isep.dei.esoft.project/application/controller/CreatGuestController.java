package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

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


}

