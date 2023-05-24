package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Roles;
import pt.ipp.isep.dei.esoft.project.domain.Store;

public class EmployeeProjectDTO extends UserDTO {
    private int salary;
    private Store store;

    private Roles[] roles;
    public EmployeeProjectDTO(String name, String descptions, int taxNumber, String email, String password,
                              String address, String phone, Roles[] roles, int salary, Store store) {
        super(name, descptions, taxNumber, email, password, address, phone, roles[0]);
        this.salary = salary;
        this.store = store;
        this.roles = roles;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Roles[] getRolesOfEmployee() {
        return roles;
    }
}