package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SubsetPartition;

import java.util.ArrayList;
import java.util.List;

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
