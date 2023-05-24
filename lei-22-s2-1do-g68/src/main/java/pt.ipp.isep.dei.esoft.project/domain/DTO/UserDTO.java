package pt.ipp.isep.dei.esoft.project.domain.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Roles;

public class UserDTO {
    private String name;
    private String descptions;
    private int taxNumber;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Roles roles;

    public UserDTO(String name, String descptions, int taxNumber, String email, String password,
                   String address, String phone, Roles roles) {
        this.name = name;
        this.descptions = descptions;
        this.taxNumber = taxNumber;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescptions() {
        return descptions;
    }

    public void setDescptions(String descptions) {
        this.descptions = descptions;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Roles[] getRoles() {
        return new Roles[]{roles};
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
