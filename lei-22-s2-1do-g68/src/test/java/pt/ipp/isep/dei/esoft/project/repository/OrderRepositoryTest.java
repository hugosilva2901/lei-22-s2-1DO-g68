package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfOrder;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @BeforeEach
    void setUp() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
    }

    @Test
    void testAddOrder() {
        Repositories repositories = Repositories.getInstance();
        OrderRepository orderRepository = repositories.getOrderRepository();
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        ClientRepository clientRepository = repositories.getClientRepository();

        List<AnnouncementDTO> announcements = announcementRepository.getAnnouncementsDTO();
        List<ClientDTO> clients = clientRepository.getClientsDTO();

        AnnouncementDTO announcement = announcements.get(0);
        ClientDTO client = clients.get(0);
        int quantity = 1;

        OrderDTO orderDTO = new OrderDTO(announcement, quantity, client, StatusOfOrder.Accepted);

        orderRepository.addOrder(orderDTO);

        assertEquals(1, orderRepository.getOrders().size());
    }


}
