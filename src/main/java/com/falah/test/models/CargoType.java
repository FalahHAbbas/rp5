package com.falah.test.models;

public class CargoType {
    private int cargoTypeId;
    private String cargoTypeName;
    private int quantity;
    private double weight;

    public CargoType() {
    }

    public CargoType(int cargoTypeId, String cargoTypeName, int quantity, double weight) {
        this.cargoTypeId = cargoTypeId;
        this.cargoTypeName = cargoTypeName;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getCargoTypeId() {
        return cargoTypeId;
    }

    public void setCargoTypeId(int cargoTypeId) {
        this.cargoTypeId = cargoTypeId;
    }

    public String getCargoTypeName() {
        return cargoTypeName;
    }

    public void setCargoTypeName(String cargoTypeName) {
        this.cargoTypeName = cargoTypeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
