package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatGuestController;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import java.util.List;


public class CreatGuestUI implements Runnable {

    private final CreatGuestController controller = new CreatGuestController();

    public void run(){
        System.out.println("--- List of Properties ---");
        showProperties();
    }

    private void showProperties() {
        List<Property> properties = PropertyRepository.getAll();
        for (Property property : properties) {
            System.out.println(property.getName() + " - " + property.getAddress() + " - R$" + property.getPrice());
        }
    }
}
