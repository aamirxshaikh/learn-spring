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

        storeList.add(new Store("Store 1"));
        storeList.add(new Store("Store 2"));
        storeList.add(new Store("Store 3"));

        return storeList;
    }
}
