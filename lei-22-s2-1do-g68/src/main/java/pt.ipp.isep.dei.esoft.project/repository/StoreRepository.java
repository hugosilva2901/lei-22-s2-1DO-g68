package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private void addEmployeeToStore(Store store, EmployeeProject employee) {
        if (store == null){
            throw new IllegalArgumentException("Store is null");
    }

        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < stores.get(i).getEmployees().size(); j++) {
                if (stores.get(i).getEmployees().get(j).getTaxNumber()==employee.getTaxNumber())
                    throw new IllegalArgumentException("Employee already exists in another store");
            }
        }
        store.getEmployees().add(employee);
    }

    public Optional<EmployeeProject> createEmployee(String name, String descptions, int taxNumber, String email, String password,
                                                    String address, String phone, Roles roles, int salary, Store store) {
        Optional<EmployeeProject> optionalValue = Optional.empty();
        if(roles != Roles.AGENT && roles != Roles.STOREMANAGER ) {
            return Optional.empty();
        }
        EmployeeProject employee = new EmployeeProject(name, descptions, taxNumber, email, password, address, phone, roles, salary, store);
        addEmployeeToStore(store,employee);
        optionalValue = Optional.of(employee);

        return optionalValue;
    }
}
