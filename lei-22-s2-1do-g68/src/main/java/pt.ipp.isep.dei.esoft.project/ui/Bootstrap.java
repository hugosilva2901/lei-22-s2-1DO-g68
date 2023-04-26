package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addOrganization();
        addStore();
        addEmployee();
        addUsers();

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
