package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class CreatGuestController {
    private AuthenticationRepository authenticationRepository = null;
    private PropertyRepository propertyRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatGuestController() {
        getAuthenticationRepository();
        getPropertyRepository();
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
    private PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the PropertyRepository
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    public List<Property> getProperties() {
        PropertyRepository propertyRepository = getPropertyRepository();
        return propertyRepository.getAll();
    }
}

