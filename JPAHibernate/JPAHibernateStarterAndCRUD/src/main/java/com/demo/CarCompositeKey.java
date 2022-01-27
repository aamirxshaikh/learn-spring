package com.demo;

import java.io.Serializable;
import java.util.Objects;

public class CarCompositeKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer nameHash;
    private Integer modelHash;
    private Float price;

    public CarCompositeKey() {
    }

    public CarCompositeKey(String nameHash, String modelHash, Float price) {
        this.nameHash = Objects.hash(nameHash);
        this.modelHash = Objects.hash(modelHash);
        this.price = price;
    }

    public Integer getNameHash() {
        return nameHash;
    }

    public void setNameHash(Integer nameHash) {
        this.nameHash = nameHash;
    }

    public Integer getModelHash() {
        return modelHash;
    }

    public void setModelHash(Integer modelHash) {
        this.modelHash = modelHash;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameHash, modelHash, price);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(! (obj instanceof CarCompositeKey)) {
            return false;
        }

        CarCompositeKey carCompositeKey = (CarCompositeKey) obj;

        return nameHash.equals(carCompositeKey.nameHash) && modelHash.equals(carCompositeKey.modelHash) && price.equals(carCompositeKey.price);
    }
}
