package pt.ipp.isep.dei.esoft.project.domain;

public class RealEstate {
    private String name;
    private String description;
    private String website;
    private String email;
    private String phone;
    private int vatNumber;
    private String address;

    public RealEstate(String name, String description, String website, String email, String phone, int vatNumber, String address) {
        this.name = name;
        this.description = description;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.vatNumber = vatNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RealEstate{" + "name=" + name + ", description=" + description + ", website=" + website + ", email=" + email + ", phone=" + phone + ", vatNumber=" + vatNumber + ", address=" + address + '}';
    }

}
