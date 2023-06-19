package pt.ipp.isep.dei.esoft.project.domain.matcp;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.StoreDTO;
import pt.ipp.isep.dei.esoft.project.domain.mapper.AnnouncementMapper;
import pt.ipp.isep.dei.esoft.project.domain.mapper.EmployeeProjectMapper;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVReader {
    StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();
   public void readCSV() throws IOException, ParseException {

       // String csvFile = "lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\domain\\matcp\\legacyRealStateUSAMoodle_MATCP_MDISC.csv";
       String csvFile= "lei-22-s2-1do-g68\\src\\main\\java\\pt.ipp.isep.dei.esoft.project\\domain\\matcp\\MATCPpresentation.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (i > 0) {
                    String id = data[0];
                    String owner_name = data[1];
                    String owner_passportNum = data[2];
                    String owner_TIN = data[3];
                    String owner_email = data[4];
                    String owner_phone = data[5];
                    String property_type = data[6];
                    String property_area = data[7];
                    String property_location = data[8];
                    String property_distanceFromCenter = data[9];
                    String property_numberBedrooms = data[10];
                    String property_numberBathrooms = data[11];
                    String property_pnumParking = data[12];
                    String property_centralHeating = data[13];
                    String property_airconditioned = data[14];
                    String property_basement = data[15];
                    String property_loft = data[16];
                    String property_sunExposure = data[17];
                    String property_requested_sale_rent_price = data[18];
                    String property_sale_rent_price = data[19];
                    String commission = data[20];
                    String contract_duration = data[21];
                    String property_dateAnnounceRequest = data[22];
                    String property_dateofSale = data[23];
                    String type_business = data[24];
                    String store_ID = data[25];
                    String store_name = data[26];
                    String store_location = data[27];
                    String store_phonenumber = data[28];
                    String store_emailAddress = data[29];
                    int number1 = Integer.parseInt(store_ID);
                    StoreDTO storeDTO = new StoreDTO(store_name, store_emailAddress, store_location, "12222", store_phonenumber, number1, null, null);
                    storeRepository.addStoreDTO(storeDTO);
                    int numberRoms = Integer.parseInt(property_numberBedrooms);
                    int numberBathrooms = Integer.parseInt(property_numberBathrooms);
                    int numberParking = Integer.parseInt(property_pnumParking);
                    List<String> equipment = new ArrayList<>();
                    if (property_centralHeating == "Y") {
                        equipment.add("centralHeating");
                    }
                    if (property_airconditioned == "Y") {
                        equipment.add("airconditioned");
                    }
                    boolean loft = false;
                    if (property_loft == "Y") {
                        loft = true;
                    }
                    boolean basement = false;
                    if (property_basement == "Y") {
                        basement = true;
                    }
                    boolean sunExposure = false;
                    if (property_sunExposure == "Y") {
                        sunExposure = true;
                    }
                    int area = Integer.parseInt(property_area);
                    int distanceFromCenter = Integer.parseInt(property_distanceFromCenter);
                    if (property_type.equals("house")) {


                        House house = new House("house", "house", property_location, "it is a house"
                                , true, false, numberRoms, numberBathrooms, 1, numberParking
                                , equipment, basement, loft, sunExposure, area, distanceFromCenter);
                        propertyRepository.add(house);
                        propertyRepository.addHouse(house);
                    } else {
                        Apartment apartment = new Apartment("apartment", "apartment",property_location, "it is a apartment"
                                , true, false, numberRoms, numberBathrooms, 2, numberParking
                                , equipment, area, distanceFromCenter);
                        propertyRepository.add(apartment);
                        propertyRepository.addApartment(apartment);
                    }
                    int priceOnTheannoucement = Integer.parseInt(property_requested_sale_rent_price);
                    EmployeeProjectDTO employeeProject=EmployeeProjectMapper.toDTO(storeRepository.listEmployees().get(0));
                    AnnouncementDTO announcementDTO = new AnnouncementDTO(propertyRepository.getAll().get(propertyRepository.getAll().size()-1),
                            priceOnTheannoucement, employeeProject, AnnouncementState.ACCEPTED);
                 //   Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(property_dateAnnounceRequest);

                    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(property_dateAnnounceRequest);
                    announcementDTO.setCreationDate(Instant.ofEpochMilli(date1.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime());
                    Announcement announcement = AnnouncementMapper.toEntity(announcementDTO);
                    announcementRepository.addAnnouncement(announcement);
                    int taxNumber = Integer.parseInt(owner_passportNum);
                    Client client = new Client(owner_name, "client form the csv", taxNumber, owner_email, "Password1", "rua de ", owner_phone, Roles.CLIENT);
                    clientRepository.addClient(client);
                    int priceOfSale = Integer.parseInt(property_sale_rent_price);
                    OrderDTO orderDTO = new OrderDTO(announcementRepository.getAnnouncementsDTO().get(announcementRepository.getAnnouncementsDTO().size()-1),
                            priceOfSale, clientRepository.getClientsDTO().get(clientRepository.getClientsDTO().size() - 1), StatusOfOrder.Accepted);
                    orderRepository.addOrder(orderDTO);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}