package pt.ipp.isep.dei.esoft.project.domain;


import static org.junit.jupiter.api.Assertions.*;
import pt.ipp.isep.dei.esoft.project.repository.*;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class OrderTeste {

    @Test
    public void testValidateOrderWithValueBelowZero() {
        // Arrange
        List<String> list= new ArrayList<>();
        House house1 = new House("Casa Tornrinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        Roles[] roles= new Roles[1] ;
        roles[0] = Roles.AGENT;
        Store store = Repositories.getInstance().getStoreRepository().getStores().get(0);
        EmployeeProject employeeProject = new EmployeeProject("Jota", "ajent", 265903075,"employee2@this.app"
                ,"hugo","rua dp calvario","910634405", roles,500, store);
        Announcement announcement = new Announcement(house1, 100, employeeProject);
        Client client = new Client("Gonçalo", "Description", 123456789, "gonçalo@example.com",
        "pwd", "Street X", "123456789", Roles.CLIENT);
        order order = new order(announcement, -100, client);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> order.validateOrder(order));
    }

    @Test
    public void testValidateOrderWithNullAnnouncement() {
        // Arrange
        Client client = new Client("Gonçalo", "Description", 123456789, "gonçalo@example.com",
                "pwd", "Street X", "123456789", Roles.CLIENT);
        order order = new order(null, 100, client);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> order.validateOrder(order));
    }

    @Test
    public void testValidateOrderWithNullClient() {
        // Arrange
        List<String> list= new ArrayList<>();
        House house1 = new House("Casa Tornrinhas", "house", "Rua das torneiras", "Muito bem equipada", true, true, 5, 5, 5, 5, list , true, true, true);
        Roles[] roles= new Roles[1] ;
        roles[0] = Roles.AGENT;
        Store store = Repositories.getInstance().getStoreRepository().getStores().get(0);
        EmployeeProject employeeProject = new EmployeeProject("Jota", "ajent", 265903075,"employee2@this.app"
                ,"hugo","rua dp calvario","910634405", roles,500, store);
        Announcement announcement = new Announcement(house1, 100, employeeProject);
        order order = new order(announcement, 100, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> order.validateOrder(order));
    }

}
