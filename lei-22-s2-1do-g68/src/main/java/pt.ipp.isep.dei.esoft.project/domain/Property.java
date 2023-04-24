package pt.ipp.isep.dei.esoft.project.domain;

public abstract class Property {
    private String name;
    private String type;
    private String address;
    private String description;
    private boolean isForSale;
    private boolean isForRent;

    public Property(String name, String type, String address, String description, boolean isForSale, boolean isForRent) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.description = description;
        this.isForSale = isForSale;
        this.isForRent = isForRent;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isForSale() {
        return isForSale;
    }
    public void setForSale(boolean isForSale) {
        this.isForSale = isForSale;
    }
    public boolean isForRent() {
        return isForRent;
    }
    public void setForRent(boolean isForRent) {
        this.isForRent = isForRent;
    }
}

