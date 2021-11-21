package com.demo.DAO;

import com.demo.Model.Store;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDAOImplementation implements StoreDAO {
    @Override
    public List<Store> getStores() {
        List<Store> storeList = new ArrayList<>();

        storeList.add(new Store("Store1"));
        storeList.add(new Store("Store2"));
        storeList.add(new Store("Store3"));

        return storeList;
    }
}
