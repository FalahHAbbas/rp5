package com.falah.test.models;

import java.util.List;
import java.util.UUID;

public class RampDetails {
    private UUID id;
    private int status;
    private int rampId;
    private Ramp ramp;
    private UUID truckTripId;
    private TruckTrip truckTrip;
    private List<PickupTrip> pickupTrips;
    private List<CargoType> cargoTypes;
    private String startDateTime;
    private String endDateTime;

    public RampDetails() {
    }

    public RampDetails(UUID id, int status, int rampId, Ramp ramp, UUID truckTripId, TruckTrip truckTrip, List<PickupTrip> pickupTrips, List<CargoType> cargoTypes, String startDateTime, String endDateTime) {
        this.id = id;
        this.status = status;
        this.rampId = rampId;
        this.ramp = ramp;
        this.truckTripId = truckTripId;
        this.truckTrip = truckTrip;
        this.pickupTrips = pickupTrips;
        this.cargoTypes = cargoTypes;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRampId() {
        return rampId;
    }

    public void setRampId(int rampId) {
        this.rampId = rampId;
    }

    public Ramp getRamp() {
        return ramp;
    }

    public void setRamp(Ramp ramp) {
        this.ramp = ramp;
    }

    public UUID getTruckTripId() {
        return truckTripId;
    }

    public void setTruckTripId(UUID truckTripId) {
        this.truckTripId = truckTripId;
    }

    public TruckTrip getTruckTrip() {
        return truckTrip;
    }

    public void setTruckTrip(TruckTrip truckTrip) {
        this.truckTrip = truckTrip;
    }

    public List<PickupTrip> getPickupTrips() {
        return pickupTrips;
    }

    public void setPickupTrips(List<PickupTrip> pickupTrips) {
        this.pickupTrips = pickupTrips;
    }

    public List<CargoType> getCargoTypes() {
        return cargoTypes;
    }

    public void setCargoTypes(List<CargoType> cargoTypes) {
        this.cargoTypes = cargoTypes;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public enum ACTION {
        READY,
        CHECKING,
        START_UNLOADING,
        FINISH_PICKUP,
        FINISH,
        STOP
    }
}
