package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.order;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;
import pt.isep.lei.esoft.auth.domain.model.User;

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

    public List<AnnouncementDTO> getAnnouncements(){
        return announcementRepository.getAnnouncementsDTO();
    }


    private ClientDTO getClientByUserEmail(String userName){
        return clientRepository.getClientByEmail(userName);
    }
    public boolean addOrder(AnnouncementDTO announcement,int value){
        ClientDTO client = getClientByUserEmail(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        if (orderRepository.createOrder(announcement, value, client).isEmpty()){
            return false;
        }
        return true;
    }

    // only to use in teste
    public boolean addOrderToTest(AnnouncementDTO announcement,int value, ClientDTO client){
        if (orderRepository.createOrder(announcement, value, client).isEmpty()){
            return false;
        }
        return true;
    }

}
