package pt.ipp.isep.dei.esoft.project.domain;

public class Land extends Property {
    private double area;

    public Land(String name, String type, String address, String description, boolean isForSale, boolean isForRent, double area) {
        super(name, type, address, description, isForSale, isForRent);
        this.area = area;
    }

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Land{" +
                "area=" + area +
                '}';
    }
}

