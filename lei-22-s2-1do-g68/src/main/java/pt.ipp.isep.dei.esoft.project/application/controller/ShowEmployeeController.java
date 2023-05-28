package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowEmployeeController {

    private AuthenticationRepository authenticationRepository = null;
    private StoreRepository storeRepository = null;

    //Repository instances are obtained from the Repositories class
    public ShowEmployeeController() {
        getAuthenticationRepository();
        getStoreRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public ShowEmployeeController(AuthenticationRepository authenticationRepository) {
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

    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the PropertyRepository
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    public void showStoresandEmployes() {
        displayEmployee();

    }

    public void displayEmployee() {
        List<Store> stores = storeRepository.getStores();

        stores.sort(Comparator.comparingInt(store -> storeRepository.countPropertiesByStore()));
        Collections.reverse(stores);

        for (Store store : stores) {
            int propertyCount = storeRepository.countPropertiesByStore();
            System.out.println("Store: "+ store.getName() + " - Property Count: " + propertyCount);
            List<EmployeeProject> employees = store.getEmployees();
            for (EmployeeProject employee : employees) {
                EmployeeProjectDTO employeeDTO = storeRepository.getEmployeeByName(employee.getName());
                System.out.println("- Employee: " + employeeDTO.getName());
            }
        }
    }
}
