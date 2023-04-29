package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;


import java.util.List;
import java.util.Optional;

public class CreatEmployeeController {

    private AuthenticationRepository authenticationRepository = null;

    private StoreRepository storeRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatEmployeeController() {
        getAuthenticationRepository();
        getStoreRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreatEmployeeController(AuthenticationRepository authenticationRepository) {

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


    public Optional<EmployeeProject> createEmployee(String name, String descptions, int taxNumber, String email, String password,
                                                    String address, String phone, Roles[] roles, int salary, Store store) {



        EmployeeProject employee = new EmployeeProject(name, descptions, taxNumber,
                email, password, address, phone, roles, salary, store);
        if (store.getEmployees().contains(employee)) {
            throw new IllegalArgumentException("There is already this employee ");
        }
        Admin admin = Admin.getInstance();

      Optional<EmployeeProject> newtask = storeRepository.createEmployee( name,  descptions,  taxNumber,  email,  password,
                 address,  phone,  roles,  salary,  store);

        for (int i = 0; i < roles.length; i++) {
            if((roles[i] != Roles.STOREMANAGER) ) {
                store.setLocalManager(employee);
            }
        }
        authenticationRepository.addUserWithRole(name,email, password, AuthenticationController.ROLE_EMPLOYEE);
        return newtask;
    }
    public List<Store> getStores() {
        StoreRepository storeRepository = getStoreRepository();
        return storeRepository.getStores();
    }
}
