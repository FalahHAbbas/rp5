package com.falah.test;


import com.falah.test.models.Trip;
import com.falah.test.services.GatesService;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    private static final GatesService gatesService = new GatesService();

    public static void main(@NotNull String[] args) {
//        new GateController(GateController.COMMAND.OPEN).execute();
//        new GateController(GateController.COMMAND.CLOSE).execute();

        new Thread(new Reader((qrData) -> {
            Gson gson = new Gson();
            Trip trip;
            try {
                trip = gson.fromJson(qrData, Trip.class);
                new ScaleService(weight -> {
                    System.out.println("Weight changed: " + weight + " kg" +
                                       "\nIs the vehicle full? (0/1)");
                    var full = new Scanner(System.in).nextInt();
                    gatesService.weight(trip, weight * 1000, full == 0, (result, message) -> {
                        if (result != null && result) {
//                            new GateController(GateController.COMMAND.OPEN).execute();
//                            new GateController(GateController.COMMAND.CLOSE).execute();
                        } else {
                            System.out.println(message);
                        }
                    });


                }).run();


                /*
                gatesService.action(trip, Trip.ACTION.ENTER_BEXY, (result, message) -> {
                    if (result != null && result) {
                        new GateController(GateController.COMMAND.OPEN).execute();
                        new GateController(GateController.COMMAND.CLOSE).execute();
                    } else {
                        System.out.println(message);
                    }
                });


                */
            } catch (Exception e) {
//                e.printStackTrace();
            }

        }, args))
                .start()
        ;
    }
}
