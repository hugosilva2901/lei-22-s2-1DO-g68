package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Optional;

public class CreatClienteController {

    private OrganizationRepository organizationRepository = null;
    private TaskCategoryRepository taskCategoryRepository = null;

    private AuthenticationRepository authenticationRepository = null;

    private StoreRepository storeRepository = null;

    private ClientRepository clientRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatClienteController() {
        getOrganizationRepository();
        getTaskCategoryRepository();
        getAuthenticationRepository();
        getStoreRepository();
        getClientRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreatClienteController(OrganizationRepository organizationRepository,
                                  TaskCategoryRepository taskCategoryRepository,
                                  AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
        this.taskCategoryRepository = taskCategoryRepository;
        this.authenticationRepository = this.authenticationRepository;
    }

    private TaskCategoryRepository getTaskCategoryRepository() {
        if (taskCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            taskCategoryRepository = repositories.getTaskCategoryRepository();
        }
        return taskCategoryRepository;
    }


    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;

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

    private ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the ClientRepository
            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    public  Optional<Client>  createClient(String name, String description, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        Optional<Client> client =  getClientRepository().addClient( name,  description,  taxNumber,  email,  password,  address,  phone,  roles);
        authenticationRepository.addUserWithRole(name,email, password, AuthenticationController.ROLE_CLIENTE);
        return client;
    }
}
