package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatClienteController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Apartment;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.domain.Land;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addStore();
        addEmployee();
        addUsers();
        addProperty();
        addAnnoucements();
    }




    private void addStore() {
        Store store = new Store("Store","9155555", "Rua do Teste", "vatnumber", "Portugal",5);
        Repositories.getInstance().getStoreRepository().addStore(store);
    }

    private void addEmployee() {
        Roles[] roles= new Roles[1] ;
        roles[0] = Roles.AGENT;
        Roles[] roles1 = new Roles[1];
        roles1[0] = Roles.STOREMANAGER;
        Store store = Repositories.getInstance().getStoreRepository().getStores().get(0);
        EmployeeProject employeeProject = new EmployeeProject("name", "ajent", 265903075,"employee2@this.app"
                ,"hugo","rua dp calvario","910634405", roles,500, store);
        Repositories.getInstance().getStoreRepository().addEmployeeToStorePublic(store,employeeProject);
    }
    private void addProperty() {
        List<String> list= new ArrayList<>();
        CreateAnnouncementController announcementController = new CreateAnnouncementController();
        CreatClienteController creatClienteController = new CreatClienteController();
        House house = new House("Casa Torneirinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        Land land = new Land("Land Torneirinhas", "land", "Rua das torneiras", "Muito bem equipada", true, true, 5);
        Apartment apartment = new Apartment("Apartment Torneirinhas", "apartment", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list);

        creatClienteController.createClient("Tiago","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Joao","f",510447465,"joao@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Luis","f",510185380,"luis@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(2), house);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(2), land);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(1), apartment);

    }
    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE,
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENTE,
                AuthenticationController.ROLE_CLIENTE);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole( Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getName()
                , Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getEmail(),
                Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getPassword(),
                AuthenticationController.ROLE_EMPLOYEE);

    }
    private void addAnnoucements() {
        CreateAnnouncementController announcementController = new CreateAnnouncementController();
        announcementController.createAnnouncement(announcementController.getClientRepository().getClients().get(2).getProperties().get(0),1000);
        announcementController.createAnnouncement(announcementController.getClientRepository().getClients().get(2).getProperties().get(1),101);
        announcementController.createAnnouncement(announcementController.getClientRepository().getClients().get(1).getProperties().get(0),1002);
    }

}
