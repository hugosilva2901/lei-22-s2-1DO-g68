package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public boolean removeAnnouncement (Announcement announcement) {
        return announcements.remove(announcement);
    }

    public Announcement createAnnouncement(Property property, int commission) {
        Announcement announcement = new Announcement(property, commission);
        addAnnouncement(announcement);
        return announcement;
    }

  /*  public void createAnnouncementFromClientProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a client:");
        int i = 1;
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
                addAnnouncement(announcement);
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

   */


}
