package com.falah.test;


import com.falah.test.models.Trip;
import com.falah.test.services.GatesService;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

public class Main {
    private static final GatesService gatesService = new GatesService();

    public static void main(@NotNull String[] args) {
        new GateController(GateController.COMMAND.OPEN).execute();
        new GateController(GateController.COMMAND.CLOSE).execute();

        new Thread(new Reader((qrData) -> {
            Gson gson = new Gson();
            Trip trip;
            try {
                trip = gson.fromJson(qrData, Trip.class);
                gatesService.action(trip, Trip.ACTION.EXIT_BEXY, (result, message) -> {
                    if (result != null && result) {
                        new GateController(GateController.COMMAND.OPEN).execute();
                        new GateController(GateController.COMMAND.CLOSE).execute();
                    } else {
                        System.out.println(message);
                    }
                });

            } catch (Exception e) {
//                e.printStackTrace();
            }

        }, "usb-Linux_3.4.39_with_sunxi_usb_udc_HID_Gadget-event-kbd", "1"))
//        }, args))
                .start()
        ;
    }
}
