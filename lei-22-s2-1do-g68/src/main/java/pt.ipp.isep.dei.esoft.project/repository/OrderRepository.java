package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfOrder;
import pt.ipp.isep.dei.esoft.project.domain.order;
import pt.ipp.isep.dei.esoft.project.domain.DTO.*;
import pt.ipp.isep.dei.esoft.project.domain.mapper.*;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderRepository {

    List<order> orders = new ArrayList<>();

    private void addOrder(order order) {
        orders.add(order);
        PutPerorder();
    }

    private void PutPerorder() {
        Collections.sort(orders, (o1, o2) -> o1.getValue() - o2.getValue());
    }

    public List<OrderDTO> getOrders() {
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    private boolean valueAlreadyExists(int value) {
        for (order o : orders) {
            if (o.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean clientAlreadyExists(ClientDTO client) {
        for (order o : orders) {
            if (o.getClient().equals(ClientMapper.toEntity(client))) {
                return true;
            }
        }
        return false;
    }


    public Optional<OrderDTO> createOrder(AnnouncementDTO announcement, int value, ClientDTO client) {
        if (announcement.getValueOfProperty() < value) {
            throw new IllegalArgumentException("The value of the order is not valid");
        }
        if (valueAlreadyExists(value)) {
            System.out.println("The value already exists in another order");
        }
        if (clientAlreadyExists(client)) {
            throw new IllegalArgumentException("The client already exists");
        }
        Optional<OrderDTO> optionalValue = Optional.empty();
        order order = new order(
                AnnouncementMapper.toEntity(announcement),
                value,
                ClientMapper.toEntity(client)
        );
        optionalValue = Optional.of(OrderMapper.toDTO(order));
        addOrder(OrderMapper.toEntity(optionalValue.get()));
        return optionalValue;

    }


    public List<OrderDTO> OrderOfTheAgent(AnnouncementDTO announcement) {

        List<OrderDTO> ordersOfTheAgent = new ArrayList<>();
        for (order o : orders) {
            if (o.getStatusOfOrder() == StatusOfOrder.Pending) {
                if (o.getAnnouncement().equals(AnnouncementMapper.toEntity(announcement))) {
                    ordersOfTheAgent.add(OrderMapper.toDTO(o));
                }
            }
        }
        return ordersOfTheAgent;
    }

    private order findOrder(OrderDTO order) {
        for (order o : orders) {
            if (o.equals(OrderMapper.toEntity(order))) {
                return o;
            }
        }
        return null;
    }

    public void acceptOrder(OrderDTO order, MessagesOfClientRepository messagesOfClientRepository) {
        order o = findOrder(order);
        o.setStatusOfOrder(StatusOfOrder.Accepted);
        Client client = o.getClient();
        messagesOfClientRepository.addMessage(client, "The " + OrderMapper.toEntity(order).toString() + " was accepted");
        List<OrderDTO> ord = OrderOfTheAgent(order.getAnnouncement());
        System.out.println("The " + OrderMapper.toEntity(order).toString() + " was accepted");
        for (OrderDTO or : ord) {
            rejectOrder(or, messagesOfClientRepository);
        }
    }

    public void rejectOrder(OrderDTO order, MessagesOfClientRepository messagesOfClientRepository) {
        order o = findOrder(order);
        o.setStatusOfOrder(StatusOfOrder.Rejected);
        Client client = o.getClient();
        messagesOfClientRepository.addMessage(client, "The" + OrderMapper.toEntity(order).toString() + "was rejected");
        System.out.println("The" + OrderMapper.toEntity(order).toString() + "was rejected");

    }

}
