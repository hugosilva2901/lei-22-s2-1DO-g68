package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
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
    private int comission;

    public static CreateAnnouncementController getController() {
        return controller;
    }

    @Override
    public void run() {
        System.out.println("Create Announcement\n");

        client=displayAndSelectClients();
        property=displayAndSelectProperty(client);
        requestData();
        submitData();
    }


    private Client displayAndSelectClients() {
        //Display the list of task categories

        List<Client> Clients = controller.getClientRepository().getClients();

        int listSize = Clients.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStoresOptionsClients(Clients);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        Client description = Clients.get(answer - 1);
        return description;

    }
    private void displayStoresOptionsClients(List<Client> Clients) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (Client Client : Clients) {
            System.out.println(i + " - " + Clients.toString());
            i++;
        }
    }

    private Property displayAndSelectProperty(Client Client) {
        //Display the list of task categories
        List<Property> Property = Client.getProperties();
        int listSize = Property.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayClientProperty(Property);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        Property description = Property.get(answer - 1);
        return description;

    }
    private void displayClientProperty(List<Property> property) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (Property p : property) {
            System.out.println(i + " - " + property.toString());
            i++;
        }
    }


    private void submitData() {
        Optional<Announcement> announcement = getController().createAnnouncement(property,comission);
        if (announcement.isPresent()) {
            System.out.println("Announcement created!");
        } else {
            System.out.println("Announcement not created!");
        }
    }
    private void requestData() {
        comission=requestComission();
    }


    private int requestComission() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the comission");
        int comission = input.nextInt();
        return comission;
    }

}
