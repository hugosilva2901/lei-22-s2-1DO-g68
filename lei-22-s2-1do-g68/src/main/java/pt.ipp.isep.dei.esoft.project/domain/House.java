package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

public class House extends Property {
    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfFloors;
    private int numberOfGarages;
    private List<String> equipments;
    private boolean hasBasement;
    private boolean hasLoft;
    private boolean hasSunExposure;

    public House(String name, String type, String address, String description, boolean isForSale, boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors, int numberOfGarages, List<String> equipments, boolean hasBasement, boolean hasLoft, boolean hasSunExposure) {
        super(name, type, address, description, isForSale, isForRent);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfFloors = numberOfFloors;
        this.numberOfGarages = numberOfGarages;
        this.equipments = equipments;
        this.hasBasement = hasBasement;
        this.hasLoft = hasLoft;
        this.hasSunExposure = hasSunExposure;
    }

    public House(String name, String type, String address, String description, boolean isForSale, boolean isForRent,
                 int numberOfRooms, int numberOfBathrooms, int numberOfFloors, int numberOfGarages, List<String> equipments,
                 boolean hasBasement, boolean hasLoft, boolean hasSunExposure,int price, int area,int distanceFromCenter) {
        super(name, type, address, description, isForSale, isForRent,price,area,distanceFromCenter);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfFloors = numberOfFloors;
        this.numberOfGarages = numberOfGarages;
        this.equipments = equipments;
        this.hasBasement = hasBasement;
        this.hasLoft = hasLoft;
        this.hasSunExposure = hasSunExposure;
    }
    // getters and setters for all fields
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public int getNumberOfGarages() {
        return numberOfGarages;
    }
    public void setNumberOfGarages(int numberOfGarages) {
        this.numberOfGarages = numberOfGarages;
    }
    public List<String> getEquipments() {
        return equipments;
    }
    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }
    public boolean hasBasement() {
        return hasBasement;
    }
    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }
    public boolean hasLoft() {
        return hasLoft;
    }
    public void setHasLoft(boolean hasLoft) {
        this.hasLoft = hasLoft;
    }
    public boolean hasSunExposure() {
        return hasSunExposure;
    }
    public void setHasSunExposure(boolean hasSunExposure) {
        this.hasSunExposure = hasSunExposure;
    }

    @Override
    public String toString() {
        return "House{" +
                "numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfGarages=" + numberOfGarages +
                ", equipments=" + equipments +
                ", hasBasement=" + hasBasement +
                ", hasLoft=" + hasLoft +
                ", hasSunExposure=" + hasSunExposure +
                '}';
    }
}


