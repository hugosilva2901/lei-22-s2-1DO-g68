package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.LegacySystemData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVLoader {

    private String fileDirectory;
    private Scanner scanner;


    public CSVLoader(String fileDirectory) throws Exception {
        checkFile(fileDirectory);
        this.fileDirectory = fileDirectory;
        getData();
    }

    private List<LegacySystemData> getData() throws FileNotFoundException {
        List<LegacySystemData> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileDirectory));
        scanner.nextLine();
        int line = 1;
        while(scanner.hasNextLine()) {
            line++;
            try {
                String data = scanner.nextLine();
                LegacySystemData legacySystemData = verifyDataFormat(data);
                dataList.add(legacySystemData);
            }catch (Exception e){
                System.out.println("Error In line: " + line +" "+ e.getMessage());
            }
        }

        return dataList;
    }
    private LegacySystemData verifyDataFormat(String info){
        String[] datas = info.split(";");

        LegacySystemData legacySystemData = new LegacySystemData();
        legacySystemData.setSid(Integer.parseInt(datas[0]));
        legacySystemData.setOwnerName(datas[1]);
        legacySystemData.setOwnerPassportNum(datas[2]);
        legacySystemData.setOwnerTIN(datas[3]);
        legacySystemData.setOwnerEmail(datas[4]);
        legacySystemData.setOwnerPhone(datas[5]);
        legacySystemData.setPropertyType(datas[6]);
        legacySystemData.setPropertyArea(verifyNumber(datas[7]));
        legacySystemData.setPropertyLocation(datas[8]);

        legacySystemData.setPropertyDistanceFromCenter(verifyNumber(datas[9]));
        legacySystemData.setPropertyNumBedrooms(verifyNumber(datas[10]));
        legacySystemData.setPropertyNumBathrooms(verifyNumber(datas[11]));
        legacySystemData.setPropertyNumParking(verifyNumber(datas[12]));

        legacySystemData.setPropertyCentralHeating(verifyTrueOrFalse(datas[13]));
        legacySystemData.setPropertyAirconditioned(verifyTrueOrFalse(datas[14]));
        legacySystemData.setPropertyBasement(verifyTrueOrFalse(datas[15]));
        legacySystemData.setPropertyLoft(verifyTrueOrFalse(datas[16]));
        legacySystemData.setPropertySunExposure(verifySunExposure(datas[17]));
        legacySystemData.setPropertyRequestedSaleRentPrice(verifyNumber(datas[18]));
        legacySystemData.setPropertySaleRentPrice(verifyNumber(datas[19]));
        legacySystemData.setCommission(verifyNumber(datas[20]));
        legacySystemData.setContractDuration(datas[21]);
        legacySystemData.setPropertyDateAnnounceRequest(datas[22]);
        legacySystemData.setPropertyDateOfSale(datas[23]);
        legacySystemData.setTypeBusiness(datas[24]);
        legacySystemData.setStoreID(datas[25]);
        legacySystemData.setStoreName(datas[26]);
        legacySystemData.setStoreLocation(datas[27]);
        legacySystemData.setStorePhoneNumber(datas[28]);
        legacySystemData.setStoreEmailAddress(datas[29]);

        return legacySystemData;
    }

    private void checkFile(String fileDirectory) throws Exception {
        File file = new File(fileDirectory);
        String[] splitFile = fileDirectory.split("\\.");
        if (!splitFile[splitFile.length - 1].equals("csv")) {
            throw new Exception("Wrong Format");
        }
        if (!file.exists()) {
            throw new Exception("File not Found");
        }
        scanner = new Scanner(file);
        if (!scanner.nextLine().equals("sid;owner_name;owner_passportNum;owner_TIN(SSN);owner_email;owner_phone;property_type;property_area(square feet);property_location;property_distanceFromCenter (miles);property_numberBedrooms;property_numberBathrooms;property_pnumParking;property_centralHeating;property_airconditioned;property_basement;property_loft;property_sunExposure;property_requested_sale_rent_price;property_sale_rent_price (USD);commission(%);contract_duration(months);property_dateAnnounceRequest;property_dateofSale;type_business;store_ID;store_name;store_location;store_phonenumber;store_emailAddress")) {
            throw new Exception("Wrong File Information");
        }
    }

    private String verifySunExposure(String info){
        if (!(info.equals("S")||info.equals("N")||info.equals("W")||info.equals("E")||info.equals("NA"))){
            throw new IllegalArgumentException("Unknown format "+"\""+info+"\"");
        }
        return info;
    }
    private boolean verifyTrueOrFalse(String info){
        if(info.equals("Y")){
            return true;
        }else if(info.equals("N")||info.equals("NA")) {
            return false;
        }
        throw new IllegalArgumentException("Unknown format "+"\""+info+"\"");
    }
    private int verifyNumber(String data){
        if(data.equals("NA")){
            return -1;
        }else
            return Integer.parseInt(data);
    }
}
