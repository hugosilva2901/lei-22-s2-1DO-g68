package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private List<Property> properties = new ArrayList<>();

    public Client(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        super(name, descptions, taxNumber, email, password, address, phone, roles);
    }

    private void validateTaxNumber(int taxNumber){
        if(taxNumber < 100000000 || taxNumber > 999999999){
            throw new IllegalArgumentException("The tax number is not valid");
        }
    }

    private void validateClient(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        validateTaxNumber(taxNumber);

    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }


}
