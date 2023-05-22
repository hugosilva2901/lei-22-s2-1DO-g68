package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.order;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class AcceptOrderController {

    OrderRepository orderRepository = null;
    StoreRepository storeRepository = null;


    AnnouncementRepository announcementRepository = null;

    MessagesOfClientRepository messagesOfClientRepository = null;

    public AcceptOrderController() {
        getOrderRepository();
        getStoreRepository();
        getAnnouncementRepository();
        getMessagesOfClientRepository();
    }


    private OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();

            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    private StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    private AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    private MessagesOfClientRepository getMessagesOfClientRepository() {
        if (messagesOfClientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            messagesOfClientRepository = repositories.getMessagesOfClientRepository();
        }
        return messagesOfClientRepository;
    }
 public List<Announcement> getAnnouncements() {
        return this.announcementRepository.getAnnouncements();
    }




    private EmployeeProject getEmployeeProject(String name) {
        return this.storeRepository.getEmployeeByName(name);
    }

    public List<Announcement> AnnoucementOfOrder(String name) {
        EmployeeProject employeeProject = getEmployeeProject(name);
        return announcementRepository.getAnnouncementsByEmployee(employeeProject);
    }

    public List<order> OrderOfAnoucement(Announcement announcement) {
        return orderRepository.OrderOfTheAgent(announcement);
    }

    public void acceptOrder(order order, int choice) {
        if (choice == 2)
            orderRepository.rejectOrder(order,messagesOfClientRepository);
        else if (choice == 1)
            orderRepository.acceptOrder(order,messagesOfClientRepository);
    }

}
