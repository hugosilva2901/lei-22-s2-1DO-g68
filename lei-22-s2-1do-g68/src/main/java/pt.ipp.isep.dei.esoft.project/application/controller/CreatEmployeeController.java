package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

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
    
}
