package pt.ipp.isep.dei.esoft.project.application.controller;

import org.testng.annotations.Test;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

public class CreateOrderTest {

    @Test
    public void testGetOrderRepository() {
        // Arrange
        CreateOrderController ctrl = new CreateOrderController();
        Announcement announcement = ctrl.getAnnouncements().get(0);
        // Act
        ctrl.addOrder(announcement, 1);

        // Assert

    }
}
