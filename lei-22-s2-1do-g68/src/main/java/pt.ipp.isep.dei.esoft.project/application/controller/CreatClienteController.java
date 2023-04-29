package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Optional;

public class CreatClienteController {


    private AuthenticationRepository authenticationRepository = null;

    private StoreRepository storeRepository = null;

    private ClientRepository clientRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatClienteController() {

        getAuthenticationRepository();
        getStoreRepository();
        getClientRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreatClienteController(
                                  AuthenticationRepository authenticationRepository) {

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
