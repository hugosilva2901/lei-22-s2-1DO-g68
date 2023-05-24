package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Roles;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO extends UserDTO {
    private List<Property> properties;

    public ClientDTO(String name, String descptions, int taxNumber, String email, String password,
                     String address, String phone, Roles roles, List<Property> properties) {
        super(name, descptions, taxNumber, email, password, address, phone, roles);
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}