package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatGuestController;
import pt.ipp.isep.dei.esoft.project.application.controller.ListDealController;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;

import java.util.*;

public class ListDealUI implements Runnable {

    private final ListDealController controller = new ListDealController();

    public void run() {
        Scanner scanner = new Scanner(System.in);

// Prompt the user to select a sorting algorithm
        System.out.println("Select a sorting algorithm:");
        System.out.println("bubble");
        System.out.println("quick");
        String sortingAlgorithm = scanner.nextLine();

// Prompt the user to select a sort order
        System.out.println("Select a sort order:");
        System.out.println("1 - Ascending");
        System.out.println("2 - Descending");
        int sortOrderOption = scanner.nextInt();
        boolean ascending = sortOrderOption == 1;


        List<OrderDTO> sortedDeals = controller.listAllDealsByPropertyArea(ascending, sortingAlgorithm, sortOrderOption);

        for (OrderDTO deal : sortedDeals) {
            System.out.println("Deal ID:" + deal.toString());
            System.out.println("Property Area:" + deal.getAnnouncement().getProperty().getProperty_area());
            System.out.println("------------------------");

        }

        // Get all deals sorted by property area in ascending order using Bubble Sort
       /* List<OrderDTO> ascendingDeals = controller.listAllDealsByPropertyArea(true, "bubble");
        System.out.println("Ascending order (Bubble Sort):");
        displayDeals(ascendingDeals);

        // Get all deals sorted by property area in descending order using Quick Sort
        List<OrderDTO> descendingDeals = controller.listAllDealsByPropertyArea(false, "quick");
        System.out.println("Descending order (Quick Sort):");
        displayDeals(descendingDeals);*/
    }

}
