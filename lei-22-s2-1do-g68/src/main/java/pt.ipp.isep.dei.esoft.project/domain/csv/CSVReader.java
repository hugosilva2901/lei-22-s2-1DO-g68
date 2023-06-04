package pt.ipp.isep.dei.esoft.project.domain.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\domain\\csv\\legacyRealStateUSAMoodle_MATCP_MDISC.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i=0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if(i>0) {
                    String id = data[0];
                    String owner_name = data [1];
                    String owner_passportNum = data [2];
                    String owner_TIN = data [3];
                    String owner_email = data [4];
                    String owner_phone = data [5];
                    String property_type = data [6];
                    String property_area= data [7];
                    String property_location = data [8];
                    String property_distanceFromCenter = data [9];
                    String property_numberBedrooms = data [10];
                    String property_numberBathrooms = data [11];
                    String property_pnumParking = data [12];
                    String property_centralHeating = data [13];
                    String property_airconditioned = data [14];
                    String property_basement = data [15];
                    String property_loft = data [16];
                    String property_sunExposure = data [17];
                    String property_requested_sale_rent_price = data [18];
                    String property_sale_rent_price = data [19];
                    String commission = data [20];
                    String contract_duration = data [21];
                    String property_dateAnnounceRequest = data [22];
                    String property_dateofSale = data [23];
                    String type_business = data [24];
                    String store_ID = data [25];
                    String store_name = data [26];
                    String store_location = data [27];
                    String store_phonenumber = data [28];
                    String store_emailAddress = data [29];

                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}