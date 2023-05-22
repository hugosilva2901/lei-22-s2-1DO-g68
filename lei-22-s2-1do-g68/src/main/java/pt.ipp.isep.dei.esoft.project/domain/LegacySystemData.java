package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class LegacySystemData {
    private int sid;
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
    private String contractDuration;
    private String propertyDateAnnounceRequest;
    private String propertyDateOfSale;
    private String typeBusiness;
    private String storeID;
    private String storeName;
    private String storeLocation;
    private String storePhoneNumber;
    private String storeEmailAddress;

    public LegacySystemData(){

    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerPassportNum(String ownerPassportNum) {
        this.ownerPassportNum = ownerPassportNum;
    }

    public void setOwnerTIN(String ownerTIN) {
        this.ownerTIN = ownerTIN;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setPropertyArea(double propertyArea) {
        this.propertyArea = propertyArea;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public void setPropertyDistanceFromCenter(double propertyDistanceFromCenter) {
        this.propertyDistanceFromCenter = propertyDistanceFromCenter;
    }

    public void setPropertyNumBedrooms(int propertyNumBedrooms) {
        this.propertyNumBedrooms = propertyNumBedrooms;
    }

    public void setPropertyNumBathrooms(int propertyNumBathrooms) {
        this.propertyNumBathrooms = propertyNumBathrooms;
    }

    public void setPropertyNumParking(int propertyNumParking) {
        this.propertyNumParking = propertyNumParking;
    }

    public void setPropertyCentralHeating(boolean propertyCentralHeating) {
        this.propertyCentralHeating = propertyCentralHeating;
    }

    public void setPropertyAirconditioned(boolean propertyAirconditioned) {
        this.propertyAirconditioned = propertyAirconditioned;
    }

    public void setPropertyBasement(boolean propertyBasement) {
        this.propertyBasement = propertyBasement;
    }

    public void setPropertyLoft(boolean propertyLoft) {
        this.propertyLoft = propertyLoft;
    }

    public void setPropertySunExposure(String propertySunExposure) {
        this.propertySunExposure = propertySunExposure;
    }

    public void setPropertyRequestedSaleRentPrice(double propertyRequestedSaleRentPrice) {
        this.propertyRequestedSaleRentPrice = propertyRequestedSaleRentPrice;
    }

    public void setPropertySaleRentPrice(double propertySaleRentPrice) {
        this.propertySaleRentPrice = propertySaleRentPrice;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }

    public void setPropertyDateAnnounceRequest(String propertyDateAnnounceRequest) {
        this.propertyDateAnnounceRequest = propertyDateAnnounceRequest;
    }

    public void setPropertyDateOfSale(String propertyDateOfSale) {
        this.propertyDateOfSale = propertyDateOfSale;
    }

    public void setTypeBusiness(String typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public void setStoreEmailAddress(String storeEmailAddress) {
        this.storeEmailAddress = storeEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegacySystemData that = (LegacySystemData) o;
        return sid == that.sid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }
}

    // getters and setters for all attributes

