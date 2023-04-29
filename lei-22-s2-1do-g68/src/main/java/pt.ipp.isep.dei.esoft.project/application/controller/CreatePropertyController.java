package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Apartment;
import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.domain.Land;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

public class CreatePropertyController {

    private PropertyRepository propertyRepository = null;

    private StoreRepository storeRepository = null;
    public CreatePropertyController() {
        getPropertyRepository();
        getStoreRepository();
    }

    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            propertyRepository = new PropertyRepository();
        }
        return propertyRepository;
    }

    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            storeRepository = new StoreRepository();
        }
        return storeRepository;
    }

    public Optional<House> createHouse (String name, String type, String address, String description, boolean isForSale,
                                       boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors,
                                       int numberOfGarages, List<String> equipments, boolean hasBasement, boolean hasLoft,
                                       boolean hasSunExposure) {
        PropertyRepository propertyRepository = getPropertyRepository();

        return propertyRepository.creatHouse(name, type, address, description, isForSale, isForRent, numberOfRooms,
                numberOfBathrooms, numberOfFloors, numberOfGarages, equipments, hasBasement, hasLoft, hasSunExposure);
        }

    public Optional<Apartment> createApartament (String name, String type, String address, String description, boolean isForSale,
                                                 boolean isForRent, int numberOfRooms, int numberOfBathrooms, int numberOfFloors,
                                                 int numberOfGarages, List<String> equipments, boolean hasBasement, boolean hasLoft,
                                                 boolean hasSunExposure) {
        PropertyRepository propertyRepository = getPropertyRepository();

        return propertyRepository.creatApartment(name, type, address, description, isForSale, isForRent, numberOfRooms,
                numberOfBathrooms, numberOfFloors, numberOfGarages, equipments);
    }

    public Optional<Land> createLand (String name, String type, String address, String description, boolean isForSale,
                                     boolean isForRent, double aree) {
        PropertyRepository propertyRepository = getPropertyRepository();

        return propertyRepository.creatLand(name, type, address, description, isForSale, isForRent, aree);
    }
}
