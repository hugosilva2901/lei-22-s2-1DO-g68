package pt.ipp.isep.dei.esoft.project.domain.DTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreDTO {
    private String name;
    private String phone;
    private String email;
    private String vatNumber;
    private String address;
    private int branchNumber;
    private List<EmployeeProjectDTO> employees;
    private EmployeeProjectDTO localManager;

    public StoreDTO(String name, String phone, String email, String vatNumber, String address,
                    int branchNumber, List<EmployeeProjectDTO> employees, EmployeeProjectDTO localManager) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.vatNumber = vatNumber;
        this.address = address;
        this.branchNumber = branchNumber;
        this.employees = employees;
        this.localManager = localManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public List<EmployeeProjectDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeProjectDTO> employees) {
        this.employees = employees;
    }

    public EmployeeProjectDTO getLocalManager() {
        return localManager;
    }

    public void setLocalManager(EmployeeProjectDTO localManager) {
        this.localManager = localManager;
    }
}