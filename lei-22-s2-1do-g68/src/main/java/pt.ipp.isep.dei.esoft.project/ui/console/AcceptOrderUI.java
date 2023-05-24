package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AcceptOrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.order;

import java.util.List;
import java.util.Scanner;

public class AcceptOrderUI implements Runnable{

    private AcceptOrderController controller= new AcceptOrderController();


    @Override
    public void run() {
        System.out.println("Accept Order\n");
        AnnouncementDTO announcement= displayAndSelectAnnouncement();
        if (announcement==null){
            System.out.println("There are no announcements to show.");
            return;
        }
        OrderDTO order= displayAndSelectOrder(announcement);

        if (order==null){
            System.out.println("There are no orders to show.");
            return;
        }
       System.out.println("Do you want to accept the order? (1-Y/N)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if(answer.equals("1")){
            controller.acceptOrder(order,1);
        }
        else{
            controller.acceptOrder(order,2);
        }
    }


     private AnnouncementDTO displayAndSelectAnnouncement() {
        List<AnnouncementDTO> announcements = controller.getAnnouncements();
        if (announcements.isEmpty()) {
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

    private OrderDTO displayAndSelectOrder(AnnouncementDTO announcement ) {
        List<OrderDTO> orders = controller.OrderOfAnoucement(announcement);
        if (orders.isEmpty()) {
            return null;
        }

        int listSize = orders.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayOrderOptions(orders);
            System.out.println("Select a order:");
            answer = input.nextInt();
        }

        OrderDTO description = orders.get(answer - 1);
        return description;

    }

    private void displayOrderOptions(List<OrderDTO> orders) {
        //display the task categories as a menu with number options to select
        int i = 1;
        for (OrderDTO order : orders) {
            System.out.println(i + " - " + order.toString());
            i++;
        }
    }
}
