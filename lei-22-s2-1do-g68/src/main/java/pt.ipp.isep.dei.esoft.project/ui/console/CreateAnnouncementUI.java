package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreateAnnouncementUI implements Runnable {
    private static CreateAnnouncementController controller = new CreateAnnouncementController();

    private Client client;
    private Property property;
    private int valueofproperty;

    public static CreateAnnouncementController getController() {
        return controller;
    }

    @Override
    public void run() {
        System.out.println("Create Announcement\n");

        client=displayAndSelectClients();
        property=displayAndSelectProperty(client);
        if (property==null){
            System.out.println("No properties to announce");
            return;
        }
        requestData();
        submitData();
    }


    private Client displayAndSelectClients() {
        List<Client> Clients = controller.getClientRepository().getClients();

        int listSize = Clients.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayClients(Clients);
            System.out.println("Select a Client:");
            answer = input.nextInt();
        }

        Client client = Clients.get(answer - 1);
        return client;

    }
    private void displayClients(List<Client> clients) {
        int i = 1;
        for (Client client : clients) {
            System.out.println(i + " - " + client.getName().toString());
            i++;
        }
    }


    private Property displayAndSelectProperty(Client client) {
        List<Property> Property = client.getProperties();
        int listSize = Property.size();
        if(listSize==0){

            return null;
        }
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayClientProperty(Property);
            System.out.println("Select a Property:");
            answer = input.nextInt();
        }

        Property description = Property.get(answer - 1);
        return description;

    }
    private void displayClientProperty(List<Property> property) {
        int i = 1;
        for (Property p : property) {
            System.out.println(i + " - " + p.getType().toString() + " - " + p.getName().toString());
            i++;
        }
    }


    private void submitData() {
        Optional<Announcement> announcement = getController().createAnnouncement(property,valueofproperty);
        if (announcement.isPresent()) {
            System.out.println("Announcement created!");
            controller.messageAnnouncement(announcement.get(), client);

        } else {
            System.out.println("Announcement not created!");
        }
    }
    private void requestData() {
        valueofproperty=requestvalue();
    }


    private int requestvalue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert value of the property");
        int valueofproperty = input.nextInt();
        return valueofproperty;
    }

}
