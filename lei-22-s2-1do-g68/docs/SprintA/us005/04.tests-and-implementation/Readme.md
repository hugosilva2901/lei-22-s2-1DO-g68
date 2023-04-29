# US 005 - To create a Store

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Store store = new Task(null, null, null, null, null, null, null);
	}

	@Test
    void createStore() {
        Store store = new Store(name,phone,email,vatNumber,address,branchNumber);
        Store testStore = storeNetWork.createStore(name,phone,email,vatNumber,address,branchNumber);
        assertEquals(store.getAddress(),testStore.getAddress());
        assertEquals(store.getBranchNumber(),testStore.getBranchNumber());
        assertEquals(store.getEmail(),testStore.getEmail());
        assertEquals(store.getPhone(),testStore.getPhone());
        assertEquals(store.getName(),testStore.getName());
        assertEquals(store.getVatNumber(),testStore.getVatNumber());
        assertTrue(testStore.getEmployees().isEmpty());

        assertTrue(storeNetWork.getRepository().getStores().contains(testStore));
    }



# 5. Construction (Implementation)
```java
 public Store(String name, String phone, String email, String vatNumber, String address, int branchNumber) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.vatNumber = vatNumber;
        this.address = address;
        this.branchNumber = branchNumber;
        this.employees = new ArrayList<>();
        validate(name,phone,email,vatNumber,address,branchNumber);
        this.localManager = null;
        }
```
## Class StoreNetwork

```java
public Store createStore(String name, String phone, String email, String vatNumber, String address, int branchNumber){
        Store store = new Store(name,phone,email,vatNumber,address,branchNumber);
        saveStore(store);
        return store;
        }
```


## Class CreateStoreController 

```java
public Store createStore(String name, String phone, String email, String vatNumber, String address, int branchNumber){
        return this.storeNetWork.createStore(name,phone,email,vatNumber,address,branchNumber);
        }
```


## Class StoreRepository

```java
 public void addStore(Store store) {
        validateStore(store);
        this.stores.add(store);
        }
```

# 6. Integration and Demo 

* Some demo purposes some Stores are bootstrapped while system starts.


# 7. Observations

StoreNetWork and RealEstate classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





