package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class ListDealController {

    private OrderRepository orderRepository;

    public ListDealController() {
        getOrderRepository();
    }

    public ListDealController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private void getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();

            // Get the OrderRepository
            orderRepository = repositories.getOrderRepository();
        }
    }

    public List<OrderDTO> listAllDealsByPropertyArea(boolean ascending, String sortingAlgorithm, int sortOrderOption) {
        List<OrderDTO> deals = orderRepository.getOrders();

        if ("bubble".equalsIgnoreCase(sortingAlgorithm)) {
            if (ascending) {
                bubbleSortAscending(deals);
            } else {
                bubbleSortDescending(deals);
            }
        } else if ("quick".equalsIgnoreCase(sortingAlgorithm)) {
            if (ascending) {
                quickSortAscending(deals, 0, deals.size() - 1);
            } else {
                quickSortDescending(deals, 0, deals.size() - 1);
            }
        }

        return deals;
    }

    private void bubbleSortAscending(List<OrderDTO> deals) {
        int n = deals.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                OrderDTO deal1 = deals.get(j);
                OrderDTO deal2 = deals.get(j + 1);

                double propertyArea1 = deal1.getAnnouncement().getProperty().getProperty_area();
                double propertyArea2 = deal2.getAnnouncement().getProperty().getProperty_area();


                if (propertyArea1 > propertyArea2) {
                    // Swap elements
                    OrderDTO temp = deals.get(j);
                    deals.set(j, deals.get(j + 1));
                    deals.set(j + 1, temp);
                }
            }
        }
    }

    private void bubbleSortDescending(List<OrderDTO> deals) {
        int n = deals.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                OrderDTO deal1 = deals.get(j);
                OrderDTO deal2 = deals.get(j + 1);

                double propertyArea1 = deal1.getAnnouncement().getProperty().getProperty_area();
                double propertyArea2 = deal2.getAnnouncement().getProperty().getProperty_area();

                if (propertyArea1 < propertyArea2) {
                    // Swap elements
                    OrderDTO temp = deals.get(j);
                    deals.set(j, deals.get(j + 1));
                    deals.set(j + 1, temp);
                }
            }
        }
    }

    private void quickSortAscending(List<OrderDTO> deals, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionAscending(deals, low, high);

            quickSortAscending(deals, low, partitionIndex - 1);
            quickSortAscending(deals, partitionIndex + 1, high);
        }
    }

    private int partitionAscending(List<OrderDTO> deals, int low, int high) {
        double pivot = deals.get(high).getAnnouncement().getProperty().getProperty_area();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (deals.get(j).getAnnouncement().getProperty().getProperty_area() < pivot) {
                i++;
                OrderDTO temp = deals.get(i);
                deals.set(i, deals.get(j));
                deals.set(j, temp);
            }
        }

        OrderDTO temp = deals.get(i + 1);
        deals.set(i + 1, deals.get(high));
        deals.set(high, temp);

        return i + 1;
    }

        private void quickSortDescending (List < OrderDTO > deals,int low, int high){
            if (low < high) {
                int partitionIndex = partitionDescending(deals, low, high);

                quickSortDescending(deals, low, partitionIndex - 1);
                quickSortDescending(deals, partitionIndex + 1, high);
            }
        }

        private int partitionDescending (List < OrderDTO > deals,int low, int high){
            double pivot = deals.get(high).getAnnouncement().getProperty().getProperty_area();
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (deals.get(j).getAnnouncement().getProperty().getProperty_area() > pivot) {
                    i++;
                    OrderDTO temp = deals.get(i);
                    deals.set(i, deals.get(j));
                    deals.set(j, temp);
                }
            }

            OrderDTO temp = deals.get(i + 1);
            deals.set(i + 1, deals.get(high));
            deals.set(high, temp);

            return i + 1;
        }
    }

