package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreNetWorkTest {

    private StoreNetWork storeNetWork;
    private String name;
    private String phone;
    private String email;
    private String vatNumber;
    private String address;
    private int branchNumber;

    private String netWorkName;
    private String netWorkAdress;




    @BeforeEach
    void setUp(){
         this.netWorkName = "NetWork";
         this.netWorkAdress = "Porto";
        storeNetWork = new StoreNetWork(netWorkName,netWorkAdress);
        this.name = "name";
        this.phone = " 12345486";
        this.email = "a123456789@gmail.com";
        this.vatNumber = "5666-123";
        this.address = "Porto/Portugal";
        this.branchNumber = 6;


    }

    @Test
    void testConstructor(){
        assertEquals(storeNetWork.getName(), netWorkName);
        assertEquals(storeNetWork.getAddress(), netWorkAdress);
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
}