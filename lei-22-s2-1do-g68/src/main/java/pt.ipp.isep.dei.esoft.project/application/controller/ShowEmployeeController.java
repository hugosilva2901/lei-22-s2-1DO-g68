package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.*;

public class ShowEmployeeController {

    private AnnouncementRepository announcementRepository = null;
    private AuthenticationRepository authenticationRepository = null;
    private StoreRepository storeRepository = null;

    //Repository instances are obtained from the Repositories class
    public ShowEmployeeController() {
        getAnnouncementRepository();
        getAuthenticationRepository();
        getStoreRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public ShowEmployeeController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = this.authenticationRepository;
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

        // Criar um mapa para armazenar o total de anúncios por loja
        Map<Store, Integer> storeAnnouncementCounts = new HashMap<>();

        for (Store store : stores) {
            List<EmployeeProject> employees = store.getEmployees();
            int totalAnnouncements = 0;

            for (EmployeeProject employee : employees) {
                EmployeeProjectDTO employeeDTO = storeRepository.getEmployeeByName(employee.getName());

                List<AnnouncementDTO> announcementsByEmployee = announcementRepository.getAnnouncementsByEmployee(employeeDTO);
                totalAnnouncements += announcementsByEmployee.size();
            }

            storeAnnouncementCounts.put(store, totalAnnouncements);
        }

        // Ordenar as lojas com base no total de anúncios em ordem decrescente
        stores.sort(Comparator.comparingInt(store -> storeAnnouncementCounts.get(store)));
        Collections.reverse(stores);

        // Exibir as informações das lojas e empregados
        for (Store store : stores) {
            int propertyCount = storeAnnouncementCounts.get(store);
            System.out.println("Store: " + store.getName() + " - Property Listing Count: " + propertyCount);

            List<EmployeeProject> employees = store.getEmployees();
            employees.sort(Comparator.comparing(EmployeeProject::getName)); // Ordenar empregados por ordem alfabética

            for (EmployeeProject employee : employees) {
                EmployeeProjectDTO employeeDTO = storeRepository.getEmployeeByName(employee.getName());
                System.out.println("- Employee: " + employeeDTO.getName());
            }
        }
    }
}
