package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    List<order> orders=new ArrayList<>();


    public void addOrder(order order){
        orders.add(order);
    }

    public List<order> getOrders(){
        return orders;
    }
    private boolean valueAlreadyExists(int value){
        for(order o:orders){
            if(o.getValue()==value){
                return true;
            }
        }
        return false;
    }
    private boolean clientAlreadyExists(Client client){
        for(order o:orders){
            if(o.getClient().equals(client)){
                return true;
            }
        }
        return false;
    }

    public  Optional<order> createOrder(Announcement announcement, int value, Client client){
        if(announcement.getValueOfProperty()>value){
            throw new IllegalArgumentException("The value of the order is not valid");
        }
        if(valueAlreadyExists(value)){
            throw new IllegalArgumentException("The value of the order already exists");
        }
        if(clientAlreadyExists(client)){
            throw new IllegalArgumentException("The client already exists");
        }
        Optional<order> optionalValue = Optional.empty();
        order order=new order(announcement,value,client);
        optionalValue = Optional.of(order);
        addOrder(order);
        return optionalValue;

    }

}
