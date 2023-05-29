package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatClienteController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateOrderController;
import pt.ipp.isep.dei.esoft.project.application.controller.VisitRequestController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.EmployeeProjectMapper;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addStore();
        addEmployee();
        addUsers();
        addProperty();
        addAnnoucements();
        addOrder();
        addVisitRequest();
    }




    private void addStore() {
        Store store = new Store("Store","9155555", "Rua do Teste", "vatnumber", "Portugal",5);
        Store store2 = new Store("ArmStrong","9166691", "Teste Rua", "vatnumber", "Portugal",1);
        Repositories.getInstance().getStoreRepository().addStore(store);
        Repositories.getInstance().getStoreRepository().addStore(store2);
    }

    private void addEmployee() {
        Roles[] roles= new Roles[1] ;
        roles[0] = Roles.AGENT;
        Roles[] roles1 = new Roles[1];
        roles1[0] = Roles.STOREMANAGER;
        Store store = Repositories.getInstance().getStoreRepository().getStores().get(0);
        Store store2 = Repositories.getInstance().getStoreRepository().getStores().get(1);
        EmployeeProject employeeProject = new EmployeeProject("Jota", "ajent", 265903075,"employee2@this.app"
                ,"hugo","rua dp calvario","910634405", roles,500, store);
        EmployeeProject employeeProject2 = new EmployeeProject("Migua", "ajent", 265903076,"employee3@this.app"
                ,"migua","rua dp calvario","910634405", roles,500, store2);
        Repositories.getInstance().getStoreRepository().addEmployeeToStorePublic(store,employeeProject);
        Repositories.getInstance().getStoreRepository().addEmployeeToStorePublic(store2,employeeProject2);
    }
    private void addProperty() {
        List<String> list= new ArrayList<>();
        CreateAnnouncementController announcementController = new CreateAnnouncementController();
        CreatClienteController creatClienteController = new CreatClienteController();
        House house = new House("Casa Torneirinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        Land land = new Land("Land Torneirinhas", "land", "Rua das torneiras", "Muito bem equipada", true, true, 5);
        Apartment apartment = new Apartment("Apartment Torneirinhas", "apartment", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list);
        House house1 = new House("Casa Tornrinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        House house2 = new House("Casa To", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        House house3 = new House("Casa T", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);


        creatClienteController.createClient("Tiago","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Joao","f",510447465,"joao@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Luis","f",510185380,"luis@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(2), house);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(0), land);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(1), apartment);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(1), house1);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(1), house2);
        announcementController.getClientRepository().addPropertyToClient(announcementController.getClientRepository().getClients().get(1), house3);

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

        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(2).getProperties().get(0),1000, EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(0).getProperties().get(0),1001,EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(1).getProperties().get(0),1002,EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(1).getProperties().get(1),1002,EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(1).getProperties().get(2),1002,EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
        announcementController.createAnnouncementBootstrao(announcementController.getClientRepository().getClients().get(1).getProperties().get(3),1002,EmployeeProjectMapper.toDTO(Repositories.getInstance().getStoreRepository().listEmployees().get(0)));
    }

    private void addOrder(){
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        CreateOrderController ctrl = new CreateOrderController();
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

        announcementRepository.getAnnouncements().get(1).setAnnouncementState(AnnouncementState.ACCEPTED);
        announcementRepository.getAnnouncements().get(0).setAnnouncementState(AnnouncementState.ACCEPTED);
        AnnouncementDTO announcement = ctrl.getAnnouncements().get(0);
        ctrl.addOrderToTest(announcement, 1,clientRepository.getClientsDTO().get(0));
        ctrl.addOrderToTest(announcement, 100,clientRepository.getClientsDTO().get(1));
        ctrl.addOrderToTest(announcement, 1,clientRepository.getClientsDTO().get(2));
    }

    private void addVisitRequest(){
        VisitRequestController ctrl = new VisitRequestController();
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        AnnouncementDTO announcement = AnnouncementMapper.toDTO( announcementRepository.getAnnouncements().get(0));
        String formatString = "24-01-2003";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
        Date date = new Date(2003, 1, 24);
        ctrl.registerVisitRequestBootstrap(date,"visit of client " + clientRepository.getClients().get(1).getName(),announcement,ClientMapper.toDTO(clientRepository.getClients().get(1)));
        date = new Date(2003, 1, 26);
        ctrl.registerVisitRequestBootstrap(date,"visit of client "+clientRepository.getClients().get(2).getName(),announcement,ClientMapper.toDTO(clientRepository.getClients().get(2)));
        date = new Date(2003, 1, 25);
        ctrl.registerVisitRequestBootstrap(date,"visit of client " + clientRepository.getClients().get(0).getName(),announcement, ClientMapper.toDTO(clientRepository.getClients().get(0)));
    }
}
