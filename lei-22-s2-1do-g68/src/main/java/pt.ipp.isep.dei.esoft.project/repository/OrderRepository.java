package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
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

    public void addOrder(OrderDTO orderDTO) {
        order order = OrderMapper.toEntity(orderDTO);
        order.setStatusOfOrder(StatusOfOrder.Accepted);
        for (order o : orders) {
            if (o.toString().equals(order.toString())) {
                return;
            }
        }
        addOrder(order);

    }

    private void PutPerorder() {
        Collections.sort(orders, (o1, o2) -> o2.getValue() - o1.getValue());
    }

    public List<OrderDTO> getOrders() {
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    private boolean valueAlreadyExists(int value, AnnouncementDTO announcement) {
        for (order o : orders) {
            if (o.getValue() == value && (o.getAnnouncement().equals(AnnouncementMapper.toEntity(announcement)))) {
                return true;
            }
        }
        return false;
    }

    private boolean clientAlreadyExists(ClientDTO client, AnnouncementDTO announcement) {
        for (order o : orders) {
            if (o.getClient().getTaxNumber() == (ClientMapper.toEntity(client)).getTaxNumber() && o.getStatusOfOrder() != StatusOfOrder.Accepted && o.getAnnouncement().toString().equals(AnnouncementMapper.toEntity(announcement).toString())) {
                return true;
            }
        }
        return false;
    }


    public Optional<OrderDTO> createOrder(AnnouncementDTO announcement, int value, ClientDTO client) {
        if (announcement.getValueOfProperty() < value) {
            System.out.println("The order amount submitted is higher than the value of the property");
            return Optional.empty();
        }
        if (valueAlreadyExists(value, announcement)) {
            System.out.println("The order amount submitted has already been posted for this property. Please contact the agent that is responsible for this property");
        }
        if (clientAlreadyExists(client, announcement)) {
            System.out.println("The client already has an order in this announcement");
            return Optional.empty();
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
                if (o.getAnnouncement().toString().equals(AnnouncementMapper.toEntity(announcement).toString())) {
                    ordersOfTheAgent.add(OrderMapper.toDTO(o));
                }
            }
        }
        return ordersOfTheAgent;
    }

    private order findOrder(OrderDTO order) {
        for (order o : orders) {
            if (o.getClient().getTaxNumber() == (OrderMapper.toEntity(order)).getClient().getTaxNumber() && o.getAnnouncement().toString().equals(OrderMapper.toEntity(order).getAnnouncement().toString())) {
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

