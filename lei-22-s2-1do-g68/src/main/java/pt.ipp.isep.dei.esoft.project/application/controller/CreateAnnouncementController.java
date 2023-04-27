package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;
import java.util.Optional;

public class CreateAnnouncementController {
    private ClientRepository clientRepository = null;
    private PropertyRepository propertyRepository = null;
    private AnnouncementRepository announcementRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreateAnnouncementController() {
        getClientRepository();
        getPropertyRepository();
        getAnnouncementRepository();
        getAuthenticationRepository();

    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreateAnnouncementController(ClientRepository clientRepository,
                                        PropertyRepository propertyRepository,
                                        AnnouncementRepository announcementRepository,
                                        AuthenticationRepository authenticationRepository) {
        this.clientRepository = clientRepository;
        this.propertyRepository = propertyRepository;
        this.announcementRepository = announcementRepository;
        this.authenticationRepository = authenticationRepository;
    }

    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the StoreRepository
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    public ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the ClientRepository
            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    public AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the ClientRepository
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public Optional<Announcement> createAnnouncement(Property property, int commission){
        return getAnnouncementRepository().createAnnouncement(property, commission);
    }

}
