# US 012 - As a system administrator, I want to import information from a legacy system that has been in use in several agencies.

# 4. Tests 

```java
@Test 
@DisplayName("test constructor with correct file")
    void testConstructor01(){
        assertDoesNotThrow(()->csvLoader = new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.csv"));
    }
    
    
@Test
@DisplayName("test constructor with wrong file format")
    void testConstructor02(){
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            new SubsetPartition("src/test/java/pt/ipp/isep/dei/esoft/project/ui/console/utils/legacyRealStateUSAMoodle.txt");
        });
    }

@Test
@DisplayName("test subset partition with store list result")
public void testSubsetPartitionWithStoreList() {

        List<Store> storeList = new ArrayList<>();
        storeList.add(new Store("Store1", Arrays.asList("Property1", "Property2")));
        storeList.add(new Store("Store2", Arrays.asList("Property3")));
        storeList.add(new Store("Store3", Arrays.asList("Property4", "Property5")));
        storeList.add(new Store("Store4", Arrays.asList("Property6")));

        SubsetPartition subsetPartition = new SubsetPartition(storeList);

        List<SubsetPartition.Tuplet> minPartition = subsetPartition.getMinPartition();

        Assert.assertEquals(2, minPartition.size());
        Assert.assertTrue(minPartition.contains(new SubsetPartition.Tuplet("Store1", 2)));
        Assert.assertTrue(minPartition.contains(new SubsetPartition.Tuplet("Store3", 2)));

        Assert.assertEquals(4, subsetPartition.getSumSubset1());
        Assert.assertEquals(3, subsetPartition.getSumSubset2());
        Assert.assertEquals(1, subsetPartition.getDifference());
        }

@Test
@DisplayName("test subset partition with infos")
public void testSubsetPartitionWithInfos() {
        
        int[][] infoArray = {
        {1, 2}, // Store1 with 2 properties
        {2, 1}, // Store2 with 1 property
        {3, 2}, // Store3 with 2 properties
        {4, 1}  // Store4 with 1 property
        };
        
        SubsetPartition subsetPartition = new SubsetPartition(infoArray);

        List<SubsetPartition.Tuplet> minPartition = subsetPartition.getMinPartition();
        
        Assert.assertEquals(2, minPartition.size());
        Assert.assertTrue(minPartition.contains(new SubsetPartition.Tuplet("1", 2)));
        Assert.assertTrue(minPartition.contains(new SubsetPartition.Tuplet("3", 2)));

        Assert.assertEquals(4, subsetPartition.getSumSubset1());
        Assert.assertEquals(3, subsetPartition.getSumSubset2());
        Assert.assertEquals(1, subsetPartition.getDifference());
        }
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



