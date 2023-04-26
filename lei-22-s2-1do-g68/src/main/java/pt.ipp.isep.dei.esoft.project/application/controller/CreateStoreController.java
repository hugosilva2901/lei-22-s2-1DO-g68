package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.domain.StoreNetWork;

public class CreateStoreController {
    private StoreNetWork storeNetWork;

    public CreateStoreController(){
        this.storeNetWork = StoreNetWork.getInstance();

    }
    public Store createStore(String name, String phone, String email, String vatNumber, String address, int branchNumber){
        return this.storeNetWork.createStore(name,phone,email,vatNumber,address,branchNumber);
    }
}
