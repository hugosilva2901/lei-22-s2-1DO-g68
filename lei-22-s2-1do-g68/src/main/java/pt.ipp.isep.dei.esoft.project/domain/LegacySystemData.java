package pt.ipp.isep.dei.esoft.project.domain;

public class LegacySystemData {
    private String sid;
    private String ownerName;
    private String ownerPassportNum;
    private String ownerTIN;
    private String ownerEmail;
    private String ownerPhone;
    private String propertyType;
    private double propertyArea;
    private String propertyLocation;
    private double propertyDistanceFromCenter;
    private int propertyNumBedrooms;
    private int propertyNumBathrooms;
    private int propertyNumParking;
    private boolean propertyCentralHeating;
    private boolean propertyAirconditioned;
    private boolean propertyBasement;
    private boolean propertyLoft;
    private String propertySunExposure;
    private double propertyRequestedSaleRentPrice;
    private double propertySaleRentPrice;
    private double commission;
    private int contractDuration;
    private String propertyDateAnnounceRequest;
    private String propertyDateOfSale;
    private String typeBusiness;
    private String storeID;
    private String storeName;
    private String storeLocation;
    private String storePhoneNumber;
    private String storeEmailAddress;

    // constructor
    public LegacySystemData(String sid, String ownerName, String ownerPassportNum, String ownerTIN, String ownerEmail,
                            String ownerPhone, String propertyType, double propertyArea, String propertyLocation,
                            double propertyDistanceFromCenter, int propertyNumBedrooms, int propertyNumBathrooms, int propertyNumParking,
                            boolean propertyCentralHeating, boolean propertyAirconditioned, boolean propertyBasement,
                            boolean propertyLoft, String propertySunExposure, double propertyRequestedSaleRentPrice,
                            double propertySaleRentPrice, double commission, int contractDuration, String propertyDateAnnounceRequest,
                            String propertyDateOfSale, String typeBusiness, String storeID, String storeName, String storeLocation,
                            String storePhoneNumber, String storeEmailAddress) {
        this.sid = sid;
        this.ownerName = ownerName;
        this.ownerPassportNum = ownerPassportNum;
        this.ownerTIN = ownerTIN;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        this.propertyType = propertyType;
        this.propertyArea = propertyArea;
        this.propertyLocation = propertyLocation;
        this.propertyDistanceFromCenter = propertyDistanceFromCenter;
        this.propertyNumBedrooms = propertyNumBedrooms;
        this.propertyNumBathrooms = propertyNumBathrooms;
        this.propertyNumParking = propertyNumParking;
        this.propertyCentralHeating = propertyCentralHeating;
        this.propertyAirconditioned = propertyAirconditioned;
        this.propertyBasement = propertyBasement;
        this.propertyLoft = propertyLoft;
        this.propertySunExposure = propertySunExposure;
        this.propertyRequestedSaleRentPrice = propertyRequestedSaleRentPrice;
        this.propertySaleRentPrice = propertySaleRentPrice;
        this.commission = commission;
        this.contractDuration = contractDuration;
        this.propertyDateAnnounceRequest = propertyDateAnnounceRequest;
        this.propertyDateOfSale = propertyDateOfSale;
        this.typeBusiness = typeBusiness;
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storePhoneNumber = storePhoneNumber;
        this.storeEmailAddress = storeEmailAddress;
    }
}

    // getters and setters for all attributes

