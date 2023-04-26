package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    StoreRepository storeRepository = new StoreRepository();

    ClientRepository clientRepository = new ClientRepository();

    PropertyRepository propertyRepository = new PropertyRepository();
    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }
    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }
}
