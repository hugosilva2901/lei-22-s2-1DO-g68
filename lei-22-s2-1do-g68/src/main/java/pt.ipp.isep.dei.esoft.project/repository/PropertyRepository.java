package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyRepository {
    List<Property> properties = new ArrayList<>();
    List<House> houses = new ArrayList<>();
    List<Apartment> apartments = new ArrayList<>();
    List<Land> lands = new ArrayList<>();

    public PropertyRepository() {
        this.properties = new ArrayList<>();
    }

    public void add(Property property) {
        properties.add(property);
    }

    public Optional<Property> getByName(String name) {
        return properties.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    public List<Property> getAll() {
        return new ArrayList<>(properties);
    }

    public boolean remove(Property property) {
        return properties.remove(property);
    }

    public void createApartment(String name, String address, String description, boolean isForSale, boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors, int numberOfGarages, List<String> equipments) {
        Apartment apartment = new Apartment(name, "Apartment", address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments);
        add(apartment);
    }

    public void createLand(String name, String address, String description, boolean isForSale, boolean isForRent, double area) {
        Land land = new Land(name, "Land", address, description, isForSale, isForRent, area);
        add(land);
    }

    public void createHouse(String name, String type, String address, String description, boolean isForSale, boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors, int numberOfGarages, List<String> equipments, boolean hasBasement, boolean hasLoft, boolean hasSunExposure) {
        House house = new House(name, "House", address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        add(house);
    }

    public Optional<House> creatHouse(String name, String type, String address, String description, boolean isForSale,
                                      boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors,
                                      int numberOfGarages, List<String> equipments, boolean hasBasement, boolean hasLoft,
                                      boolean hasSunExposure) {
        Optional<House> optionalValue = Optional.empty();
        House house=new House(name, type, address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        optionalValue = Optional.of(house);
        houses.add(house);
        return optionalValue;
    }
    public Optional<Apartment> creatApartment(String name, String type, String address, String description, boolean isForSale,
                                      boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors,
                                      int numberOfGarages, List<String> equipments) {
        Optional<Apartment> optionalValue = Optional.empty();
        Apartment apartment=new Apartment(name, type, address, description, isForSale, isForRent, numberOfRooms, numberOfBathrooms, numberOfFloors, numberOfGarages, equipments);
        optionalValue = Optional.of(apartment);
        apartments.add(apartment);
        return optionalValue;
    }

    public Optional<Land> creatLand(String name, String type, String address, String description, boolean isForSale,
                                      boolean isForRent, double area) {
        Optional<Land> optionalValue = Optional.empty();
        Land land=new Land(name, type, address, description, isForSale, isForRent, area);
        optionalValue = Optional.of(land);
        lands.add(land);
        return optionalValue;
    }
}
