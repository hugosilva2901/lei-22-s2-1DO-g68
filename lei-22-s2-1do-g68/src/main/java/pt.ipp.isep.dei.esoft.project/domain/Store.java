package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {
    private String name;
    private String phone;
    private String email;
    private String vatNumber;
    private String address;
    private int branchNumber;

    private List<EmployeeProject> employees;
    private List<Property> properties;
    private Repositories repositories = Repositories.getInstance();
    private EmployeeProject localManager;
    public Store(String name, String phone, String email, String vatNumber, String address, int branchNumber) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.vatNumber = vatNumber;
        this.address = address;
        this.branchNumber = branchNumber;
        this.employees = new ArrayList<>();
        this.properties = new ArrayList<>();
        validate(name,phone,email,vatNumber,address,branchNumber);
        this.localManager = null;
    }

    public EmployeeProject getLocalManager() {
        return localManager;
    }

    public void setLocalManager(EmployeeProject localManager) {
        this.localManager = localManager;
    }

    public List<EmployeeProject> getEmployees() {
        return employees;
    }

    public List<Property> getProperties(){return properties;}

    public void setEmployees(List<EmployeeProject> employees) {
        this.employees = employees;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public boolean validate(String name, String phone, String email, String vatNumber, String address, int branchNumber){
        return true;
    }


    @Override
    public String toString() {
        return "Store{" + "name=" + name + ", phone=" + phone + ", email=" + email + ", vatNumber=" + vatNumber + ", address=" + address + ", branchNumber=" + branchNumber + '}';
    }
}
