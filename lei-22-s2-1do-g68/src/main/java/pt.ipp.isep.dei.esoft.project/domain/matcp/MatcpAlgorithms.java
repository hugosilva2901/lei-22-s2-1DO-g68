package pt.ipp.isep.dei.esoft.project.domain.matcp;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

public class MatcpAlgorithms {
    StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();

    private void values() {
        DescriptiveStatistics stats = new DescriptiveStatistics();

    }

}
