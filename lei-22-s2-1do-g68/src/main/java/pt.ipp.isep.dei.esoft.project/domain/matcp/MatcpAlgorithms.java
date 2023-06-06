package pt.ipp.isep.dei.esoft.project.domain.matcp;

import pt.ipp.isep.dei.esoft.project.repository.*;

public class MatcpAlgorithms {
    StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();

    private void values() {

    }

}
