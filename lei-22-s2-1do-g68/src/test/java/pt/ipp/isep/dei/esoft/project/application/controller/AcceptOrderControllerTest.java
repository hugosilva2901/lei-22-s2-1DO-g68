package pt.ipp.isep.dei.esoft.project.application.controller;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfOrder;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcceptOrderControllerTest {
    @Test
    public void testAcceptOrder() {
        Repositories repos = Repositories.getInstance();
        Bootstrap boot = new Bootstrap();
        boot.run();
        OrderRepository orderRepository = repos.getOrderRepository();
        AnnouncementRepository announcementRepository = repos.getAnnouncementRepository();
        AcceptOrderController ctrl = new AcceptOrderController();
        ctrl.acceptOrder(orderRepository.getOrders().get(0),2);
        ctrl.OrderOfAnoucement(AnnouncementMapper.toDTO(announcementRepository.getAnnouncements().get(2)));

        assertFalse(orderRepository.getOrders().isEmpty());
    }
    @Test
    public void testAcceptOrder2() {
        Repositories repos = Repositories.getInstance();
        Bootstrap boot = new Bootstrap();
        boot.run();
        OrderRepository orderRepository = repos.getOrderRepository();
        AnnouncementRepository announcementRepository = repos.getAnnouncementRepository();
        AcceptOrderController ctrl = new AcceptOrderController();
        ctrl.acceptOrder(orderRepository.getOrders().get(0),1);
        ctrl.OrderOfAnoucement(AnnouncementMapper.toDTO(announcementRepository.getAnnouncements().get(2)));

        assertTrue(orderRepository.getOrders().get(0).getStatusOfOrder()== StatusOfOrder.Accepted);
        List<OrderDTO> list= orderRepository.OrderOfTheAgent(orderRepository.getOrders().get(0).getAnnouncement());
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(1).getStatusOfOrder()== StatusOfOrder.Rejected);
        }

    }

}
