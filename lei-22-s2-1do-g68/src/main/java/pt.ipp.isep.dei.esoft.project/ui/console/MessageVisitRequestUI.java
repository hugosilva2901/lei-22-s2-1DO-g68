package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MessageVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.List;
import java.util.Scanner;

public class MessageVisitRequestUI implements Runnable{

    MessageVisitRequestController controller = new MessageVisitRequestController();
    private VisitRequestDTO visitRequestDTO;
    @Override
    public void run() {
        visitRequestDTO= displayAndSelectVisitRequest();
        if(visitRequestDTO==null){
            System.out.println("There are no Visit Requests to show.\n");
            return;
        }
        String message = Requestmessage();
        String messagefinal= controller.ResponseOfRequest(message,visitRequestDTO);
        System.out.println(messagefinal);

    }

    private VisitRequestDTO displayAndSelectVisitRequest() {
        //Display the list of task categories

        List<VisitRequestDTO> visitRequest = controller.getAllVisitRequests();

        int listSize = visitRequest.size();
        if (listSize == 0) {
            System.out.println("There are no Visit Requests to show.\n");
            return null;
        }
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayVisitRequests(visitRequest);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        VisitRequestDTO description = visitRequest.get(answer - 1);
        return description;

    }

    private void displayVisitRequests(List<VisitRequestDTO> visitRequests){
        int i=1;
        for (VisitRequestDTO visitRequest : visitRequests) {
            System.out.println(""+i+" "+visitRequest.toString());
            i++;
        }

    }

    private String Requestmessage(){
        System.out.println("Write a message to the Visit Request");
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        return message;
    }
}
