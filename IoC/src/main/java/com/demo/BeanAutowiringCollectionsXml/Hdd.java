package com.demo.BeanAutowiringCollectionsXml;

public class Hdd {
    private String storageCapacity;
    private String hddInterface;
    private String brand;

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getHddInterface() {
        return hddInterface;
    }

    public void setHddInterface(String hddInterface) {
        this.hddInterface = hddInterface;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Hdd{" +
                "storageCapacity='" + storageCapacity + '\'' +
                ", hddInterface='" + hddInterface + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
