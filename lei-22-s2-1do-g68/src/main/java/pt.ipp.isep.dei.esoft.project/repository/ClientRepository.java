package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Roles;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    List<Client> clients = new ArrayList<>();

    public void addOwner(Client client) {
        clients.add(client);
    }

    public List<Client> getOwners() {
        return clients;
    }

    public Client getOwnerByTaxNumber(int taxNumber) {
        for (Client client : clients) {
            if (client.getTaxNumber() == taxNumber) {
                return client;
            }
        }
        return null;
    }

    public boolean removeOwner(Client client) {
        return clients.remove(client);
    }

    private void validateTaxNumber(int taxNumber){
        if(taxNumber < 100000000 || taxNumber > 999999999){
            throw new IllegalArgumentException("The tax number is not valid");
        }
    }

    private void validateOwner(Client client) {
        validateTaxNumber(client.getTaxNumber());
    }

    public Client createOwner(String name, String description, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        Client client = new Client(name, description, taxNumber, email, password, address, phone, roles);
        validateOwner(client);
        addOwner(client);
        return client;
    }

    public void addPropertyToOwner(Client client, Property property) {
        Client clientToUpdate = getOwnerByTaxNumber(client.getTaxNumber());
        if (clientToUpdate != null) {
            clientToUpdate.addProperty(property);
        }
    }

}
