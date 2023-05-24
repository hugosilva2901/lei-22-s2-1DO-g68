package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Roles;

public class EmployeeProjectDTO extends UserDTO {
    private int salary;
    private StoreDTO store;

    public EmployeeProjectDTO(String name, String descptions, int taxNumber, String email, String password,
                              String address, String phone, Roles[] roles, int salary, StoreDTO store) {
        super(name, descptions, taxNumber, email, password, address, phone, roles[0]);
        this.salary = salary;
        this.store = store;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }
}