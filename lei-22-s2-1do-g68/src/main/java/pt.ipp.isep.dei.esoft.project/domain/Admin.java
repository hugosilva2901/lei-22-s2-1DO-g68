package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Optional;



public class Admin extends User{

    private static Admin instance= new Admin();

    private Admin() {
        super("admin", "administrador do projeto", 26903076, "hugo@email.com", "amdmin", "rua calvario", "910634405", Roles.ADIMIN);
    }
    public static Admin getInstance() {
        return instance;
    }

    public Optional<EmployeeProject>  createEmployee(String name, String descptions, int taxNumber, String email, String password,
                                        String address, String phone, Roles roles, int salary, Store store) {
        Optional<EmployeeProject> optionalValue = Optional.empty();
        if(roles != Roles.AGENT && roles != Roles.STOREMANAGER ) {
            return Optional.empty();
        }
        EmployeeProject employee = new EmployeeProject(name, descptions, taxNumber, email, password, address, phone, roles, salary, store);
        store.getEmployees().add(employee);
        optionalValue = Optional.of(employee);

        return optionalValue;
    }


}
