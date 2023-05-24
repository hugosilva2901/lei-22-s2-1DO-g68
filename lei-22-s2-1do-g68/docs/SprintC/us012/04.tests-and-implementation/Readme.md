# US 012 - As a system administrator, I want to import information from a legacy system that has been in use in several agencies.

# 4. Tests 

```java
 @Test (test constructor with correct file)
    void testConstructor01(){
        assertDoesNotThrow(()->csvLoader = new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.csv"));
    }
    
    @Test (test constructor with wrong file format)
    void testConstructor02(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.txt");
        });
    }
    
    @Test (test constructor with no header)
    void testConstructor03(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest.txt");
        });    }

    @Test (test constructor with wrong header)
    void testConstructor04(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new CSVLoader("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest2.txt");
        });    }
```




# 5. Construction (Implementation)
```java
   public CSVLoader(String fileDirectory) throws Exception {
        checkFile(fileDirectory);
        this.fileDirectory = fileDirectory;
        this.propertyRepository = Repositories.getInstance().getPropertyRepository();
        this.clientRepository = Repositories.getInstance().getClientRepository();
        this.storeRepository = Repositories.getInstance().getStoreRepository();
        }
```
## Class LegacySystemData

```java
private int sid;
private String ownerName;
private String ownerPassportNum;
private String ownerTIN;
private String ownerEmail;
private String ownerPhone;
private PropertyType propertyType;
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
```


## Class ImportLegacySystemFileController 

```java
public ImportLegacySystemFileController(){
        }

public void getData(String data) throws Exception {
        CSVLoader csvLoader = new CSVLoader(data);
        csvLoader.getData();
        }
```


## Class ImportLegacySystemDataUI

```java
@Override
public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input File Directory:");
        String dir = scanner.nextLine();

        try {
        controller.getData(dir);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        System.out.println();

        }
```

# 6. Integration and Demo 

Run the ImportLegacySystemDataUI class and provide the file directory of the sample CSV file. The application should handle the file import and display any relevant messages, such as successful import or specific error messages if any issues occur.

# 7. Observations

The CSVLoader class is responsible for loading data from a CSV file, while the ImportLegacySystemFileController class uses CSVLoader to import the data. The ImportLegacySystemDataUI class interacts with the user and invokes the getData method of the controller.




