# US 012 - As a system administrator, I want to import information from a legacy system that has been in use in several agencies.

# 4. Tests 

```java
 @Test (test constructor with correct file)
    void testConstructor01(){
        assertDoesNotThrow(()->csvLoader = new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.csv"));
    }
    
    @Test (test constructor with wrong file format)
    void testConstructor02(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.txt");
        });
    }
    
    @Test (test constructor with no header)
    void testConstructor03(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest.txt");
        });    }

    @Test (test constructor with wrong header)
    void testConstructor04(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodleTest2.txt");
        });    }
```




# 5. Construction (Implementation)
```java
  public SubsetPartition(List<Store> storeList){
        this.tupletList = loadTuplet(storeList);
        this.sumSubset1 = calculateSum(findMinPartition());
        this.sumSubset2 = calculateSum(tupletList) - sumSubset1;
        this.difference = Math.abs(sumSubset1 - sumSubset2);
        }
```
## Class SubsetPartition

```java
private List<Tuplet> tupletList;
private List<Tuplet> minPartition;
private int sumSubset1;
private int sumSubset2;
private int difference;
private class Tuplet{
    private String storeId;
    private int propertyCount;

    public Tuplet (String storeId , int propertyCount){
        this.storeId = storeId;
        this.propertyCount = propertyCount;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    public String getStoreId() {
        return storeId;
    }

    @Override
    public String toString() {
        return "Tuplet{" +
                "storeId='" + storeId + '\'' +
                ", propertyCount=" + propertyCount +
                '}';
    }
}
```


## Class CalculatePartitionController 

```java
public class CalculatePartitionController {

    private StoreRepository repository;
    public CalculatePartitionController (){
        repository = Repositories.getInstance().getStoreRepository();
    }
    public SubsetPartition calculateWithNstores(int n){
        return new SubsetPartition(getNstoreFromRepository(n));
    }
    public SubsetPartition calculateAll(){
        return new SubsetPartition(repository.getStores());
    }
    private List<Store> getNstoreFromRepository(int n){
        List<Store> stores = new ArrayList<>();
        int x = 0;
        for(Store store : repository.getStores()){

            if(n == x ){
                break;
            }else{
                stores.add(store);
            }
        }
        return stores;
    }
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

N/A
# 7. Observations

The analysis must import data before making the performance calculation in order to obtain something.



