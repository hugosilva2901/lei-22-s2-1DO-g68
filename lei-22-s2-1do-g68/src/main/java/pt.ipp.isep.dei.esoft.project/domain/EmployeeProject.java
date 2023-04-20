package pt.ipp.isep.dei.esoft.project.domain;

public class EmployeeProject extends User{
    private int salary;

    public EmployeeProject(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles, int salary) {
        super(name, descptions, taxNumber, email, password, address, phone, roles);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
