package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatGuestController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import java.util.List;
import java.util.Scanner;


public class CreatGuestUI implements Runnable {

    private final CreatGuestController controller = new CreatGuestController();

    public void run() {
        System.out.println("--- List of Properties ---");
        showProperties();
        filterPropertiesByType();
        System.out.println("--- Filter by Numerber of rooms? ---");
        System.out.println("Yes - 1");
        System.out.println("No - 2");
        Scanner scanInt = new Scanner(System.in);
        int op = scanInt.nextInt();
        switch (op) {
            case 1:
                showAnnouncementsByNumberOfRooms();
                break;
            case 2:
                showProperties();
                break;
        }

    }

    private void showProperties() {
        List<Announcement> announcements = controller.getAnnouncementRepository().getAnnouncements();
        displayAnnouncementsOptions(announcements);
    }

    private void displayAnnouncementsOptions(List<Announcement> announcements) {
        //display the Annoucements categories as a menu with number options to select
        int i = 1;
        for (Announcement announcement : announcements) {
            System.out.println(i + " - " + announcement.toString());
            i++;
        }
    }

    private void showAnnouncementsByNumberOfRooms() {
        System.out.println("--- List of Properties by Number of Rooms ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rooms: ");
        int numberOfRooms = scanner.nextInt();
        List<Announcement> announcements = controller.getAnnouncementsByNumberOfRooms(numberOfRooms);
        displayAnnouncementsOptions(announcements);
    }

    private void filterPropertiesByType() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type of property to filter (apartment, house, land): ");
        String propertyType = scanner.nextLine();

        List<Announcement> filteredAnnouncements = controller.FilterPropertiesTypeChoice(propertyType);

        if (!filteredAnnouncements.isEmpty()) {
            System.out.println("--- Filtered Properties ---");
            for (Announcement announcement : filteredAnnouncements) {
                System.out.println(announcement.getProperty().toString());
            }
        } else {
            System.out.println("No properties of the selected type were found.");
        }
    }
}