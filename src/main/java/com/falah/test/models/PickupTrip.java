package com.falah.test.models;

public class PickupTrip {
    private String id;
    private String vehicleId;
    private int plateNumber;
    private int provinceId;
    private String provinceName;
    private int plateCharacterId;
    private String plateCharacter;
    private int location;
    private int status;
    private String cargoTypeName;
    private String driverPhoneNumber;
    private boolean selectExchange;

    public PickupTrip() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getPlateCharacterId() {
        return plateCharacterId;
    }

    public void setPlateCharacterId(int plateCharacterId) {
        this.plateCharacterId = plateCharacterId;
    }

    public String getPlateCharacter() {
        return plateCharacter;
    }

    public void setPlateCharacter(String plateCharacter) {
        this.plateCharacter = plateCharacter;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCargoTypeName() {
        return cargoTypeName;
    }

    public void setCargoTypeName(String cargoTypeName) {
        this.cargoTypeName = cargoTypeName;
    }

    public boolean isSelectExchange() {
        return selectExchange;
    }

    public void setSelectExchange(boolean selectExchange) {
        this.selectExchange = selectExchange;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }
}
