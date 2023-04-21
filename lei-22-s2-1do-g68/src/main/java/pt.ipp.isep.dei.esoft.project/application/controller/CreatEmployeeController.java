package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Admin;

import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;
import pt.ipp.isep.dei.esoft.project.repository.TaskCategoryRepository;



import java.util.Optional;

public class CreatEmployeeController {

    private OrganizationRepository organizationRepository = null;
    private TaskCategoryRepository taskCategoryRepository = null;

    private AuthenticationRepository authenticationRepository = null;

    private StoreRepository storeRepository = null;

    //Repository instances are obtained from the Repositories class
    public CreatEmployeeController() {
        getOrganizationRepository();
        getTaskCategoryRepository();
        getAuthenticationRepository();
        getStoreRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreatEmployeeController(OrganizationRepository organizationRepository,
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


    public Optional<EmployeeProject> createEmployee(String name, String descptions, int taxNumber, String email, String password,
                                         String address, String phone, Roles roles, int salary, Store store) {

        if(roles != Roles.AGENT && roles != Roles.STOREMANAGER ) {
            throw new IllegalArgumentException("The role is not valid");

        } else if (roles == Roles.STOREMANAGER) {
            if(store.getLocalManager()!=null){
                 throw new IllegalArgumentException("There is already a local manager for this store");
            }

        }

        EmployeeProject employee = new EmployeeProject(name, descptions, taxNumber,
                email, password, address, phone, roles, salary, store);
        if (store.getEmployees().contains(employee)) {
            throw new IllegalArgumentException("There is already this employee ");
        }
        Admin admin = Admin.getInstance();

      Optional<EmployeeProject> newtask = admin.createEmployee( name,  descptions,  taxNumber,  email,  password,
                 address,  phone,  roles,  salary,  store);

        return newtask;
    }
    
}
