package pt.ipp.isep.dei.esoft.project.domain;

public abstract class Property {
    private String name;
    private String type;
    private String address;
    private String description;
    private boolean isForSale;
    private boolean isForRent;

    private int property_area;
    private int distanceFromCenter;

    private int price;

    public Property(String name, String type, String address, String description, boolean isForSale, boolean isForRent) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.description = description;
        this.isForSale = isForSale;
        this.isForRent = isForRent;
    }

    public Property(String name, String type, String address, String description, boolean isForSale, boolean isForRent, int property_area, int distanceFromCenter) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.description = description;
        this.isForSale = isForSale;
        this.isForRent = isForRent;
        this.property_area = property_area;
        this.distanceFromCenter = distanceFromCenter;

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

    public int getProperty_area() {
        return property_area;
    }

    public void setProperty_area(int property_area) {
        this.property_area = property_area;
    }

    public int getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(int distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", isForSale=" + isForSale +
                ", isForRent=" + isForRent +
                '}';
    }
}

