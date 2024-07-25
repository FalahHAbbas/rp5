package com.falah.test;

import xyz.cp74.evdev.EventType;
import xyz.cp74.evdev.InputDevice;

import java.util.Scanner;

public class Reader implements Runnable {

    private OnResultReceived onResultReceived;

    private final String path;
    private boolean shift = false;
    private String text = "";

    public Reader(OnResultReceived onResultReceived, String... args) {
        onDeviceAttached();
        String id;
        int pathTypeId;
        if (args.length < 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter id: ");
            id = scanner.nextLine();
            System.out.println("======================\nPath types:");
            System.out.println("1. By id");
            System.out.println("2. By path");
            System.out.println("3. By name");
            System.out.print("Enter path type id: ");
            pathTypeId = scanner.nextInt();
        } else {
            id = args[0];
            pathTypeId = Integer.parseInt(args[1]);
        }


        var pathType = switch (pathTypeId) {
            case 1 -> Reader.PATH_TYPE.BY_ID;
            case 2 -> Reader.PATH_TYPE.BY_PATH;
            case 3 -> Reader.PATH_TYPE.BY_NAME;
            default -> throw new IllegalStateException("Unexpected value: " + pathTypeId);
        };
        this.onResultReceived = onResultReceived;
        path = switch (pathType) {
            case BY_ID -> "/dev/input/by-id/" + id;
            case BY_PATH -> "/dev/input/by-path/" + id;
            case BY_NAME -> "/dev/input/" + id;
        };
    }

    @Override
    public void run() {
        onDeviceAttached();
        InputDevice device = new InputDevice(path);
        device.start();
        device.onAttach(this::onDeviceAttached);
        device.onDetach(this::onDeviceAttached);
        device.onEvent((ev) -> {
            if (ev.getType() == EventType.KEY.getId()) {
                switch (ev.getCode()) {
                    case 28:
                        onResultReceived.onResult(text);
                        text = "";
                        return;
                    case 42:
                    case 54:
                        if (ev.getValue() == 1) shift = true;
                        return;
                }
                if (ev.getValue() == 0) try {
                    var c = shift ? SpecialChar.get(ev.getCode()).getValue() : Letter.get(ev.getCode()).getValue();
                    text += c;
                    shift = false;
//                    System.out.println("Right: " + ev.getCode());
                } catch (Exception e) {
//                    System.out.println("Error: " + ev.getCode());
                }
            }
        });
        while (true) {
        }
    }

    //   "ipId":"e538d5b9-5f92-4f7a-8dd2-2d71d5a84ee5","vehicleType":0}
//{"tripId":"e538d5b9-5f92-4f7a-8dd2-2d71d5a84ee5","vehicleType":0}
    public enum PATH_TYPE {
        BY_ID,
        BY_PATH,
        BY_NAME
    }



    private void onDeviceAttached() {
        try {
            Runtime.getRuntime().exec("sudo chmod 7777 -R /dev/input");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
