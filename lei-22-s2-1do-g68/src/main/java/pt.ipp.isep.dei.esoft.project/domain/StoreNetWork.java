package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

public class StoreNetWork {

    private static StoreNetWork singleton = null;

    private String name;
    private String address;
    private StoreRepository repository;

    public StoreNetWork(String name, String address) {
        this.repository = Repositories.getInstance().getStoreRepository();
        this.name = name;
        this.address = address;
    }

    public Store createStore(String name, String phone, String email, String vatNumber, String address, int branchNumber){
        Store store = new Store(name,phone,email,vatNumber,address,branchNumber);
        saveStore(store);
        return store;
    }

    private void saveStore(Store store){
        this.repository.addStore(store);
    }

    public static StoreNetWork getInstance() {
        if(singleton == null)
        {
            synchronized(StoreNetWork.class)
            {
                singleton = new StoreNetWork("NetWork","Porto/Lisbon");
            }
        }
        return singleton;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
