package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.mapper.EmployeeProjectMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.OrderMapper;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.Comparator;
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
        EmployeeProjectDTO employeeProjectDTO = getEmployeeByName(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        EmployeeProject employeeProject = EmployeeProjectMapper.toEntity(employeeProjectDTO);

        return getAnnouncementRepository().createAnnouncement(property, commission, employeeProject);
    }


    //this method is only to use in the bootstrap
    public Optional<Announcement> createAnnouncementBootstrao(Property property, int commission, EmployeeProjectDTO employeeProjectDTO) {
        EmployeeProject employeeProject = EmployeeProjectMapper.toEntity(employeeProjectDTO);

        return getAnnouncementRepository().createAnnouncement(property, commission, employeeProject);
    }


    public List<AnnouncementDTO> getPendingAnnouncementsByDate(String employeeProject) {
        return getAnnouncementRepository().getPendingAnnouncementsByDate(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
    }

    public void changeAnnouncementState(AnnouncementDTO announcement, AnnouncementState newState) {
        getAnnouncementRepository().changeAnnouncementState(announcement, newState);
    }


}


