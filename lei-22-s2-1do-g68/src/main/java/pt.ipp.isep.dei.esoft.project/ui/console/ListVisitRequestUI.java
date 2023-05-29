package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;

import java.util.List;

public class ListVisitRequestUI implements Runnable {

    ListVisitRequestController controller = new ListVisitRequestController();

    public void run() {
        System.out.println("List of Visit Requests:");
        displayVisitRequests( controller.getAllVisitRequests());
    }

   private void displayVisitRequests(List<VisitRequestDTO> visitRequests){
        for (VisitRequestDTO visitRequest : visitRequests) {
            System.out.println(visitRequest.toString());
        }

    }
}
