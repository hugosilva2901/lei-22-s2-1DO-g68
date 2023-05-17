package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;

import java.io.File;
import java.util.Scanner;

public class CSVLoader {

    private String fileDirectory;
    private Scanner scanner = new Scanner(System.in);

    public CSVLoader(String fileDirectory) throws Exception {
        checkFile(fileDirectory);
        this.fileDirectory = fileDirectory;
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
}
