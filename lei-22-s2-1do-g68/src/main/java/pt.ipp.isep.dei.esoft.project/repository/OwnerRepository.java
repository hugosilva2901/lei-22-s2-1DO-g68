package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.domain.Roles;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {
    List<Owner> owners = new ArrayList<>();

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public Owner getOwnerByTaxNumber(int taxNumber) {
        for (Owner owner : owners) {
            if (owner.getTaxNumber() == taxNumber) {
                return owner;
            }
        }
        return null;
    }

    public boolean removeOwner(Owner owner) {
        return owners.remove(owner);
    }

    private void validateTaxNumber(int taxNumber){
        if(taxNumber < 100000000 || taxNumber > 999999999){
            throw new IllegalArgumentException("The tax number is not valid");
        }
    }

    private void validateOwner(Owner owner) {
        validateTaxNumber(owner.getTaxNumber());
    }

    public Owner createOwner(String name, String description, int taxNumber, String email, String password, String address, String phone, Roles roles) {
        Owner owner = new Owner(name, description, taxNumber, email, password, address, phone, roles);
        validateOwner(owner);
        addOwner(owner);
        return owner;
    }

}
