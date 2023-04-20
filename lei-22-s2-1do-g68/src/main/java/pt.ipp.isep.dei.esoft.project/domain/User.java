package pt.ipp.isep.dei.esoft.project.domain;

abstract class User {
    private String name;
    private String descptions;
    private int taxNumber;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Roles roles;

public User(String name, String descptions, int taxNumber, String email, String password, String address, String phone, Roles roles) {
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

    public String getDescptions() {
        return descptions;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescptions(String descptions) {
        this.descptions = descptions;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", descptions=" + descptions + ", taxNumber=" + taxNumber + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", roles=" + roles + '}';
    }




}
