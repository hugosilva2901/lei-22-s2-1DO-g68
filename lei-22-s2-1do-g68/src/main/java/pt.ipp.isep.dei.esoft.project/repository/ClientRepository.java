package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.mapper.ClientMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.OrderMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientRepository {
    List<Client> clients = new ArrayList<>();

    public Optional<Client> addClient(String name, String description, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        Optional<Client> optionalValue = Optional.empty();
        if (getClientByTaxNumber(taxNumber) != null) {

        }
        Client client = new Client(name, description, taxNumber, email, password, address, phone, roles);
        optionalValue = Optional.of(client);
        validateClient(client);
        clients.add(client);
        return optionalValue;
    }

    public boolean addClient(Client client){
        return clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<ClientDTO> getClientsDTO() {
        return clients.stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }
    public Client getClientByTaxNumber(int taxNumber) {
        for (Client client : clients) {
            if (client.getTaxNumber() == taxNumber) {
                return client;
            }
        }
        return null;
    }

    private void validateClient(Client client) {
        for (int i = 0; i < this.clients.size(); i++) {
            if(this.clients.get(i).getTaxNumber() == client.getTaxNumber()) {
                throw new IllegalArgumentException("Client already exists");
            }if (this.clients.get(i).getEmail().equals(client.getEmail())) {
                throw new IllegalArgumentException("Client already exists");
            }
        }
        if (this.clients.contains(client)) {
            throw new IllegalArgumentException("Client already exists");
        }
    }
    public boolean removeClient(Client client) {
        return clients.remove(client);
    }


    public void addPropertyToClient(Client client, Property property) {
        Client clientToUpdate = getClientByTaxNumber(client.getTaxNumber());
        if (clientToUpdate != null) {
            clientToUpdate.addProperty(property);
        }
    }

    public ClientDTO getClientByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return ClientMapper.toDTO(client);
            }
        }
        return null;
    }

}
