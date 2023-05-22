package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.StatusOfOrder;
import pt.ipp.isep.dei.esoft.project.domain.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    List<order> orders = new ArrayList<>();


    public void addOrder(order order) {
        orders.add(order);

    }

    private void PutPerorder() {
        Collections.sort(orders, (o1, o2) -> o1.getValue() - o2.getValue());
    }

    public List<order> getOrders() {
        return orders;
    }

    private boolean valueAlreadyExists(int value) {
        for (order o : orders) {
            if (o.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean clientAlreadyExists(Client client) {
        for (order o : orders) {
            if (o.getClient().equals(client)) {
                return true;
            }
        }
        return false;
    }


    public Optional<order> createOrder(Announcement announcement, int value, Client client) {
        if (announcement.getValueOfProperty() < value) {
            throw new IllegalArgumentException("The value of the order is not valid");
        }
        if (valueAlreadyExists(value)) {
            System.out.println("The value already exists in another order");
        }
        if (clientAlreadyExists(client)) {
            throw new IllegalArgumentException("The client already exists");
        }
        Optional<order> optionalValue = Optional.empty();
        order order = new order(announcement, value, client);
        optionalValue = Optional.of(order);
        addOrder(order);
        return optionalValue;

    }


    public List<order> OrderOfTheAgent(Announcement announcement) {

        List<order> ordersOfTheAgent = new ArrayList<>();
        for (order o : orders) {
            if (o.getStatusOfOrder() == StatusOfOrder.Pending) {
                if (o.getAnnouncement().equals(announcement)) {
                    ordersOfTheAgent.add(o);
                }
            }
        }
        return ordersOfTheAgent;
    }

    private order findOrder(order order) {
        for (order o : orders) {
            if (o.equals(order)) {
                return o;
            }
        }
        return null;
    }

    public void acceptOrder(order order,MessagesOfClientRepository messagesOfClientRepository) {
        order o = findOrder(order);
        o.setStatusOfOrder(StatusOfOrder.Accepted);
        Client client = o.getClient();
        messagesOfClientRepository.addMessage(client, "The "+ order.toString() + " was accepted");
        List<order> ord= OrderOfTheAgent (order.getAnnouncement());
        System.out.println("The "+ order.toString() + " was accepted");
        for (order or: ord) {
            rejectOrder(or, messagesOfClientRepository);
        }
    }

    public void rejectOrder(order order,MessagesOfClientRepository messagesOfClientRepository) {
        order o = findOrder(order);
        o.setStatusOfOrder(StatusOfOrder.Rejected);
        Client client = o.getClient();
        messagesOfClientRepository.addMessage(client, "The" + order.toString() + "was rejected");
        System.out.println("The" + order.toString() +"was rejected");

    }

}
