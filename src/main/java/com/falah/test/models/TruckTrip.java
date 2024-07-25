package com.falah.test.models;

public class TruckTrip {
    private String id;
    private String vehicleId; 
    private int plateNumber; 
    private int provinceId;
    private String provinceName; 
    private int plateCharacterId;
    private String plateCharacter;
    private int location; 
    private int status;
    private String cargoDescription; 
    private String deliveryAddress; 
    private int dischargeType; 
    private int cargoTypeId; 
    private String cargoTypeName;
    private int quantity; 
    private double weight; 
    private String driverName;
    private String driverPhone; 

    public TruckTrip() {
    }

    public TruckTrip(String id, String vehicleId, int plateNumber, int provinceId, String provinceName, int plateCharacterId, String plateCharacter, int location, int status, String cargoDescription, String deliveryAddress, int dischargeType, int cargoTypeId, String cargoTypeName, int quantity, double weight, String driverName, String driverPhone) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.plateCharacterId = plateCharacterId;
        this.plateCharacter = plateCharacter;
        this.location = location;
        this.status = status;
        this.cargoDescription = cargoDescription;
        this.deliveryAddress = deliveryAddress;
        this.dischargeType = dischargeType;
        this.cargoTypeId = cargoTypeId;
        this.cargoTypeName = cargoTypeName;
        this.quantity = quantity;
        this.weight = weight;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
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

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(int dischargeType) {
        this.dischargeType = dischargeType;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
