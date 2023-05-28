package pt.ipp.isep.dei.esoft.project.application.controller;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.domain.AnnouncementState;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateOrderTest {

    @Test
    public void testGetOrderRepository() {
        Bootstrap boot = new Bootstrap();
        boot.run();
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        // Arrange
        CreateOrderController ctrl = new CreateOrderController();
        ctrl.getAnnouncements().get(0).setAnnouncementState(AnnouncementState.ACCEPTED);
        AnnouncementDTO announcement = ctrl.getAnnouncements().get(0);

        // Act
        ctrl.addOrderToTest(announcement, 1,clientRepository.getClientsDTO().get(0));
        ctrl.addOrderToTest(announcement, 100,clientRepository.getClientsDTO().get(1));
        ctrl.addOrderToTest(announcement, 1,clientRepository.getClientsDTO().get(2));

        ctrl.addOrderToTest( ctrl.getAnnouncements().get(1), 1,clientRepository.getClientsDTO().get(0));
        ctrl.addOrderToTest( ctrl.getAnnouncements().get(1), 100,clientRepository.getClientsDTO().get(1));
        ctrl.addOrderToTest( ctrl.getAnnouncements().get(1), 1,clientRepository.getClientsDTO().get(2));

        // Assert
        assertFalse(ctrl.orderRepository.getOrders().isEmpty());
    }


}
