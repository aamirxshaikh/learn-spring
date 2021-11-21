package com.demo.Service;

import com.demo.DAO.StoreDAO;
import com.demo.Model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImplementation implements StoreService{
    @Autowired
    StoreDAO storeDAO;

    @Override
    public List<Store> getStores() {
        return storeDAO.getStores();
    }
}
