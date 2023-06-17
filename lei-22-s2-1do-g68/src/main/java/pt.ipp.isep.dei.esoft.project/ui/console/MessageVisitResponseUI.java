package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MessageVisitResponseController;
import pt.ipp.isep.dei.esoft.project.domain.MessageVisit;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfMessage;

import java.util.List;
import java.util.Scanner;

public class MessageVisitResponseUI implements Runnable{

    MessageVisitResponseController controller = new MessageVisitResponseController();
    private MessageVisit messageVisit;

    @Override
    public void run() {

        System.out.println("Do you want to accept or reject a Visit Request?");
        System.out.println("1 - Accept");
        System.out.println("2 - Reject");
        System.out.println("0 - Exit");
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 0 || answer > 2) {
            System.out.println("Select an option:");
            answer = input.nextInt();
        }

        switch (answer) {
            case 1:
                runAccept();
                break;
            case 2:
                runReject();
                break;
            case 0:
                break;
        }


    }

    private void runAccept() {
        messageVisit= displayAndSelectMessageVisit();
        if(messageVisit==null){
            System.out.println("There are no Visit messages to show.\n");
            return;
        }
       controller.AcceptVisitRequest(messageVisit, StatusOfMessage.ACCEPTED);
    }


    private void runReject() {
        messageVisit= displayAndSelectMessageVisit();



        String message = RequestmessageConfimation();
        controller.RejectVisitRequest(messageVisit,StatusOfMessage.REJECTED, message);
        System.out.println(message);
    }



    private MessageVisit displayAndSelectMessageVisit() {

        List<MessageVisit> messageVisit = controller.getMessagesOfVisit();
        if (messageVisit == null) {
            System.out.println("There are no Visit messages to show.\n");
            return null;
        }

        int listSize = messageVisit.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayMessageVisit(messageVisit);
            System.out.println("Select a store:");
            answer = input.nextInt();
        }

        MessageVisit description = messageVisit.get(answer - 1);
        return description;

    }

    private void displayMessageVisit(List<MessageVisit> messageVisit){
        int i=1;
        for (MessageVisit messageVisit1 : messageVisit) {
            System.out.println(""+i+" "+messageVisit1.toString());
            i++;
        }

    }

    private String RequestmessageConfimation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write the message confirmation:");
        String message = input.nextLine();
        return message;
    }


}
