package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;
import java.util.Optional;

public class CreateAnnouncementController {
    private ClientRepository clientRepository = null;
    private PropertyRepository propertyRepository = null;
    private AnnouncementRepository announcementRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    private StoreRepository storeRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreateAnnouncementController() {
        getClientRepository();
        getPropertyRepository();
        getAnnouncementRepository();
        getAuthenticationRepository();
        getStoreRepository();

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

    private StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the StoreRepository
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    private EmployeeProjectDTO getEmployeeByName(String name) {
        return storeRepository.getEmployeeByName(name);
    }

    public Optional<Announcement> createAnnouncement(Property property, int commission) {
        EmployeeProjectDTO employeeProject = getEmployeeByName(authenticationRepository.getCurrentUserSession().getUserName());

        return getAnnouncementRepository().createAnnouncement(property, commission, employeeProject);
    }

    //this method is only to use in the bootstrap
    public Optional<Announcement> createAnnouncementBootstrao(Property property, int commission, EmployeeProjectDTO employeeProject) {
        return getAnnouncementRepository().createAnnouncement(property, commission, employeeProject);
    }


}


