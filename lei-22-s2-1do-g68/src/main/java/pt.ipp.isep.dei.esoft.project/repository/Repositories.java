package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    StoreRepository storeRepository = new StoreRepository();

    ClientRepository clientRepository = new ClientRepository();

    PropertyRepository propertyRepository = new PropertyRepository();
    AnnouncementRepository announcementRepository = new AnnouncementRepository();

    MessagesOfClientRepository messagesOfClientRepository = new MessagesOfClientRepository();
    OrderRepository orderRepository = new OrderRepository();
    VisitRepository visitRepository = new VisitRepository();

    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }

    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    public MessagesOfClientRepository getMessagesOfClientRepository() {
        return messagesOfClientRepository;
    }

    public VisitRepository getVisitRepository() {
        return visitRepository;
    }

}
