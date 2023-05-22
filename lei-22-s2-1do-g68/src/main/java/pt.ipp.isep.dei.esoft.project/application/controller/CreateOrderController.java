package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.order;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class CreateOrderController {

    OrderRepository orderRepository = null;
    AnnouncementRepository announcementRepository = null;

    AuthenticationRepository authenticationRepository = null;

    ClientRepository clientRepository = null;
    public CreateOrderController() {
        getOrderRepository();
        getAnnouncementRepository();
        getAuthenticationRepository();
        getClientRepository();
    }

    private AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();


            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    private OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();

            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    public List<Announcement> getAnnouncements(){
        return announcementRepository.getAnnouncements();
    }


    private Client getClientByUserName(String userName){
        return clientRepository.getClientByName(userName);
    }
    public boolean addOrder(Announcement announcement,int value){
        Client client = getClientByUserName(authenticationRepository.getCurrentUserSession().getUserName());
        if (orderRepository.createOrder(announcement, value, client).isEmpty()){
            return false;
        }
        return true;
    }


}
