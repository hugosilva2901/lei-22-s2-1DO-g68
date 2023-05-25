package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
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

    public List<AnnouncementDTO> getAnnouncements() {
        return this.announcementRepository.getAnnouncementsDTOAccepted();
    }


    private EmployeeProjectDTO getEmployeeProject(String name) {
        return this.storeRepository.getEmployeeByName(name);
    }

    public List<AnnouncementDTO> AnnoucementOfOrder(String name) {
        EmployeeProjectDTO employeeProject = getEmployeeProject(name);
        return announcementRepository.getAnnouncementsByEmployee(employeeProject);
    }

    public List<OrderDTO> OrderOfAnoucement(AnnouncementDTO announcement) {
        List<OrderDTO> orders = orderRepository.OrderOfTheAgent(announcement);
        if (orders.isEmpty()) {
            System.out.println("There are no orders to show.");
        }
        return orders;
    }

    public void acceptOrder(OrderDTO order, int choice) {
        if (choice == 2)
            orderRepository.rejectOrder(order, messagesOfClientRepository);
        else if (choice == 1)
            orderRepository.acceptOrder(order, messagesOfClientRepository);
    }

}
