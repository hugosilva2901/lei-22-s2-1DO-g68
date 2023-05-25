package pt.ipp.isep.dei.esoft.project.application.controller;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
