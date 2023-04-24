package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Owner;

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

}
