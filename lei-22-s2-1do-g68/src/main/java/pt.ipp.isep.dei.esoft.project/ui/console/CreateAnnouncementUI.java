package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.util.List;
import java.util.Scanner;

public class CreateAnnouncementUI implements Runnable {
    private static CreateAnnouncementController controller = new CreateAnnouncementController();


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a client:");
        int i = 1;
        List<Client> clients = controller.getClientRepository().getClients();
        for (Client client : clients) {
            System.out.println(i + " - " + client.getName());
            i++;
        }

        System.out.println("Enter the number of the client you want to select:");
        int clientIndex = scanner.nextInt();

        if (clientIndex > 0 && clientIndex <= clients.size()) {
            Client chosenClient = clients.get(clientIndex - 1);
            System.out.println("Properties for " + chosenClient.getName() + ":");
            int j = 1;
            for (Property property : chosenClient.getProperties()) {
                System.out.println(j + " - " + property.getType());
                j++;
            }

            System.out.println("Enter the number of the property you want to select:");
            int propertyIndex = scanner.nextInt();

            if (propertyIndex > 0 && propertyIndex <= chosenClient.getProperties().size()) {
                Property chosenProperty = chosenClient.getProperties().get(propertyIndex - 1);
                System.out.println("Details for " + chosenProperty.getType() + ":");
                System.out.println("Address: " + chosenProperty.getAddress());

                System.out.println("Enter the commission for this property:");
                int commission = scanner.nextInt();

                Announcement announcement = new Announcement(chosenProperty, commission);
                controller.getAnnouncementRepository().addAnnouncement(announcement);
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

}
