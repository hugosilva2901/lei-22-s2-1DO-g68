package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.VisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static pt.ipp.isep.dei.esoft.project.repository.VisitRepository.visitList;

public class VisitRequestUI implements Runnable{

    private final VisitRequestController controller = new VisitRequestController();

    private String date;
    private String message;
    private Announcement announcement;
    private Client client;

    private VisitRequestController getController(){
        return controller;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Visit Request:\n");
        System.out.println("1-Create a Visit Request");
        System.out.println("2-See the list of Visit Requests");

        int answer = input.nextInt();
        if (answer == 1) {
            announcement = displayAndSelectAnnouncement();
            requestData();
            submitData();
        } else if (answer == 2) {
            displayVisitList(visitList);
            displayVisitListMessage(visitList);
        } else {
            System.out.println("Invalid input");
        }

    }

    private void submitData() {
        if (getController().registerVisitRequest(date, message, announcement, client)) {
            System.out.println("Visit Request successfully created.");
        } else {
            System.out.println("An error occurred. Please try again.");
        }
    }

    private Announcement displayAndSelectAnnouncement() {
        List<Announcement> announcements = getController().getAnnouncementRepository().getAnnouncements();

        int listSize = announcements.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayAnnouncements(announcements);
            System.out.println("Select an Announcement:");
            answer = input.nextInt();
        }

        Announcement announcement = announcements.get(answer - 1);
        return announcement;
    }

    private void displayAnnouncements(List<Announcement> announcements) {
        int i = 1;
        for (Announcement announcement : announcements) {
            System.out.println(i + " - " + announcement.getAnnouncementState());
            i++;
        }
    }

    private String displayVisitMessage(){
        List<VisitRequest> visitList = getController().getVisitRepository().getVisitList();

        if (visitList.isEmpty()){
            System.out.println("There are no Visit Requests to show.");
            return null;
        }

        int listSize = visitList.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayVisitListMessage(visitList);
            System.out.println("Select a Visit date:");
            answer = input.nextInt();

            int i = 1;
            for (VisitRequest visit : visitList) {
                System.out.println( i + " - " + visit.getMessage());
                i++;
            }
        }


        VisitRequest visit = visitList.get(answer - 1);
        return visit.getMessage();
    }

    private void displayVisitListMessage(List<VisitRequest> visitList) {
        int i = 1;
        for (VisitRequest visit : visitList) {
            System.out.println(i + " - " + visit.getMessage());
            i++;
        }
    }

    private void displayVisitList(List<VisitRequest> visitList) {
        int i = 1;
        for (VisitRequest visit : visitList) {
            System.out.println(i + " - " + visit.getDate());
            i++;
        }
    }


    private void requestData(){
        this.date = requestDate();
        this.message = requestMessage();
    }

    private String requestDate(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert a date:");
        return input.nextLine();
    }

    private String requestMessage(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert a message:");
        return input.nextLine();
    }


}
