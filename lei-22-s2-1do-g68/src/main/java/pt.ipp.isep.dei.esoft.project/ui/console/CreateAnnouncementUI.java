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

        List<Client> Stores = controller.getClientRepository().getClients();

        int listSize = Stores.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStoresOptionsClients(Stores);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        Client description = Stores.get(answer - 1);
        return description;

    }
    private void displayStoresOptionsClients(List<Client> Stores) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (Client Store : Stores) {
            System.out.println(i + " - " + Stores.toString());
            i++;
        }
    }

    private Property displayAndSelectProperty(Client Store) {
        //Display the list of task categories
        List<Property> Stores = Store.getProperties();
        int listSize = Stores.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStoresProperty(Stores);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        Property description = Stores.get(answer - 1);
        return description;

    }
    private void displayStoresProperty(List<Property> Stores) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (Property Store : Stores) {
            System.out.println(i + " - " + Stores.toString());
            i++;
        }
    }


    private void submitData() {
        Optional<Announcement> task = getController().createAnnouncement(property,comission);
        if (task.isPresent()) {
            System.out.println("Employee successfully created!");
        } else {
            System.out.println("Employee not created!");
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
