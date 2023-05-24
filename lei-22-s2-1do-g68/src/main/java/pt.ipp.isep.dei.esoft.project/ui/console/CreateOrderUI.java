package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateOrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;

import java.util.List;
import java.util.Scanner;

public class CreateOrderUI implements Runnable{

    CreateOrderController controller = new CreateOrderController();

    private AnnouncementDTO announcement;
    private int value;


    @Override
    public void run() {
        System.out.println("Create Order\n");
       this.announcement= displayAndSelectAnnouncement();

         System.out.println("Insert the value of the order");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();
            this.value = answer;

            submitData();

    }

    private void submitData() {
        if (controller.addOrder(announcement, value)) {
            System.out.println("Order created successfully.");
        } else {
            System.out.println("Order not created.");
        }
    }


    private AnnouncementDTO displayAndSelectAnnouncement() {
        //Display the list of task categories

        List<AnnouncementDTO> announcements = controller.getAnnouncements();
        if (announcements.isEmpty()) {
            System.out.println("There are no announcements to show.");
            return null;
        }

        int listSize = announcements.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayAnnouncementOptions(announcements);
            System.out.println("Select a announcements:");
            answer = input.nextInt();
        }

        AnnouncementDTO description = announcements.get(answer - 1);
        return description;

    }

    private void displayAnnouncementOptions(List<AnnouncementDTO> announcements) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (AnnouncementDTO announcement : announcements) {
            System.out.println(i + " - " + announcement.toString());
            i++;
        }
    }
}
