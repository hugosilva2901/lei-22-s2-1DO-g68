package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    List<Store> stores = new ArrayList<>();

    public void addStore(Store store) {
        validateStore(store);
        this.stores.add(store);
    }

    private void validateStore(Store store) {
        if (this.stores.contains(store)) {
            throw new IllegalArgumentException("Store already exists");
        }
    }
}
