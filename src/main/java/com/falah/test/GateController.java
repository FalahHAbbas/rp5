package com.falah.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GateController {
    private final Integer pin;

    public GateController(COMMAND command) {
        this.pin = switch (command) {
            case OPEN -> 21;
            case CLOSE -> 26;
        };
    }

    public void execute() {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "main.py", pin.toString());
        System.out.println("Executing command: " +
                           String.join(" ", processBuilder.command())
        );
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
            int exitValue = process.exitValue();
            System.out.println("Process exited with value: " + exitValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public enum COMMAND {
        OPEN,
        CLOSE
    }
}
