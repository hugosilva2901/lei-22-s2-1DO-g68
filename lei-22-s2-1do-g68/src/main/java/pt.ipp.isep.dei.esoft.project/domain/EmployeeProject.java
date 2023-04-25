package pt.ipp.isep.dei.esoft.project.domain;

public class EmployeeProject extends User{
    private int salary;

    private Store store;
    public EmployeeProject(String name, String descptions, int taxNumber, String email, String password,
                           String address, String phone, Roles[] roles, int salary, Store store) {
        super(name, descptions, taxNumber, email, password, address, phone, roles[0]);
        this.salary = salary;
        this.store = store;
        validateEmployee(name, descptions, taxNumber, email, password, address, phone, roles, salary, store);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private void validateSalary(int salary){
        if(salary < 0){
            throw new IllegalArgumentException("The salary is not valid");
        }
    }
    private void validateStore(Store store){
        if(store == null){
            throw new IllegalArgumentException("The store is not valid");
        }
    }
    private void validateTaxNumber(int taxNumber){
        if(taxNumber < 100000000 || taxNumber > 999999999){
            throw new IllegalArgumentException("The tax number is not valid");
        }
    }
    private void validateEmployee(String name, String descptions, int taxNumber, String email, String password,
                                  String address, String phone, Roles[] roles, int salary, Store store) {
        validateSalary(salary);
        validateStore(store);
        validateTaxNumber(taxNumber);
    }

}
