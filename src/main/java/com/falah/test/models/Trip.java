package com.falah.test.models;

import java.util.UUID;

public class Trip {
    private UUID tripId;
    private int vehicleType;

    public Trip() {
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public enum ACTION {
        ENTER_BEXY,
        ENTER_WAITING_YARD,
        ENTER_EXCHANGE_YARD,
        EXIT_EXCHANGE_YARD,
        EXIT_BEXY
    }
}
