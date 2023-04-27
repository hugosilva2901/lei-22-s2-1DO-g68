package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatClienteController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addOrganization();
        addStore();
        addEmployee();
        addUsers();
        addProperty();

    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
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
        House house = new House("Casa Torneirinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        Land land = new Land("Land Torneirinhas", "land", "Rua das torneiras", "Muito bem equipada", true, true, 5);
        Apartment apartment = new Apartment("Apartment Torneirinhas", "apartment", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list);

        Client joao = new Client("Joao","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        Client tiago = new Client("Tiago","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        Client luis = new Client("Luis","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        CreatClienteController creatClienteController = new CreatClienteController();
        creatClienteController.createClient("Joao","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Tiago","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        creatClienteController.createClient("Luis","f",254054706,"tiago@this.app","tiago","aggaga","910634405",Roles.CLIENT);
        CreateAnnouncementController announcementController = new CreateAnnouncementController();
        announcementController.getClientRepository().addPropertyToClient(joao, house);
        announcementController.getClientRepository().addPropertyToClient(tiago, land);
        announcementController.getClientRepository().addPropertyToClient(tiago, apartment);

    }
    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE,
                AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole( Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getName()
                , Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getEmail(),
                Repositories.getInstance().getStoreRepository().getStores().get(0).getEmployees().get(0).getPassword(),
                AuthenticationController.ROLE_EMPLOYEE);
    }
}
