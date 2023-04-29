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

    public void run(){
        System.out.println("--- List of Properties ---");
        showProperties();
    }

    private void showProperties() {
        List<Announcement> announcements = controller.getAnnouncementRepository().getAnnouncements();
        displayAnnoucementsOptions(announcements);
    }

    private void displayAnnoucementsOptions(List<Announcement> announcements) {
        //display the Annoucements categories as a menu with number options to select
        int i = 1;
        for (Announcement announcement : announcements) {
            System.out.println(i + " - " + announcement.toString());
            i++;
        }
    }
}
