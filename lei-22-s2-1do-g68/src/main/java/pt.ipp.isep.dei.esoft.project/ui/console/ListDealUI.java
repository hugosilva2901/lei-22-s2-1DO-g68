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
        System.out.println("List of Deals:");
        System.out.println("Select sorting order:");
        System.out.println("1 - Ascending");
        System.out.println("2 - Descending");
        int sortOrderOption = scanner.nextInt();
        if (sortOrderOption != 1 && sortOrderOption != 2) {
            System.out.println("Invalid input. Please choose either 1 or 2.");
            return;
        }



        System.out.println("Select sorting algorithm:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Quick Sort");
        System.out.println("3 - Default (Bubble Sort)");
        int sortingOption = scanner.nextInt();
        boolean ascending = true;

        String sortingAlgorithm;
        if (sortingOption == 1) {
            sortingAlgorithm = "bubble";
        } else if (sortingOption == 2) {
            sortingAlgorithm = "quick";
        } else {
            // invalid inputs will choose bubble sort as default
            sortingAlgorithm = "bubble";
        }

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
