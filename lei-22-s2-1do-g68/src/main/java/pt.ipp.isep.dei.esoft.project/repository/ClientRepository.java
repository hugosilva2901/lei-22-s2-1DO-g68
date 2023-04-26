package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository {
    List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClientByTaxNumber(int taxNumber) {
        for (Client client : clients) {
            if (client.getTaxNumber() == taxNumber) {
                return client;
            }
        }
        return null;
    }

    public boolean removeClient(Client client) {
        return clients.remove(client);
    }


    public  Optional<Client>  createClient(String name, String description, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        Optional<Client> optionalValue = Optional.empty();

        Client client = new Client(name, description, taxNumber, email, password, address, phone, roles);
        optionalValue = Optional.of(client);
        addClient(client);
        return optionalValue;
    }


    public void addPropertyToOwner(Client client, Property property) {
        Client clientToUpdate = getClientByTaxNumber(client.getTaxNumber());
        if (clientToUpdate != null) {
            clientToUpdate.addProperty(property);
        }
    }

}
