package com.falah.test.services;


import com.falah.test.core.OnCompleteListener;
import com.falah.test.models.Error;
import com.falah.test.models.Trip;
import com.falah.test.models.TripWeighted;
import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class GatesService {

    public static String baseUrl = "https://progress-api-bexy.digital-logic-gen.com/api/";

    public static final String RESERVATIONS = baseUrl + "Reservations/";
    public static final String BASE_URL_GATES = RESERVATIONS + "Gates/";

    public static final String ENTER_BEXY = "Enter-Bexy";
    public static final String ENTER_WAITING_YARD = "Enter-Waiting-Yard";
    public static final String ENTER_EXCHANGE_YARD = "Enter-Exchange-Yard";
    public static final String EXIT_EXCHANGE_YARD = "Exit-Exchange-Yard";
    public static final String EXIT_BEXY = "Exit-Bexy";

    public static final String ENTER_BEXY_URL = BASE_URL_GATES + ENTER_BEXY;
    public static final String ENTER_WAITING_YARD_URL = BASE_URL_GATES + ENTER_WAITING_YARD;
    public static final String ENTER_EXCHANGE_YARD_URL = BASE_URL_GATES + ENTER_EXCHANGE_YARD;
    public static final String EXIT_EXCHANGE_YARD_URL = BASE_URL_GATES + EXIT_EXCHANGE_YARD;
    public static final String EXIT_BEXY_URL = BASE_URL_GATES + EXIT_BEXY;


    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    public void action(Trip trip, Trip.ACTION action, OnCompleteListener<Boolean> listener) {
        RequestBody body = RequestBody.create(gson.toJson(trip), okhttp3.MediaType.parse("application/json"));
        var url = switch (action) {
            case ENTER_BEXY -> ENTER_BEXY_URL;
            case ENTER_WAITING_YARD -> ENTER_WAITING_YARD_URL;
            case ENTER_EXCHANGE_YARD -> ENTER_EXCHANGE_YARD_URL;
            case EXIT_EXCHANGE_YARD -> EXIT_EXCHANGE_YARD_URL;
            case EXIT_BEXY -> EXIT_BEXY_URL;
        };
        Request request = new Request.Builder().url(url).put(body).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();

                listener.onComplete(null, new Error(e.getMessage()));
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                var body = response.body().string();
                if (response.isSuccessful()) {
                    listener.onComplete(true, null);
                } else {
                    System.out.println(body);
                    var error = gson.fromJson(body, Error.class);


                    listener.onComplete(null, error);
                }
                System.out.println(body);

            }
        });

    }

    public void weight(Trip trip, double weight, boolean fuull, OnCompleteListener<Boolean> listener) {
        var tripWeight = new TripWeighted();
        tripWeight.setTripId(trip.getTripId());
        tripWeight.setVehicleType(trip.getVehicleType());
        tripWeight.setWeight(weight);
        RequestBody body = RequestBody.create(gson.toJson(tripWeight), okhttp3.MediaType.parse("application/json"));
        var url = RESERVATIONS + "Weighbridges/" + (fuull ? "Full" : "Empty");
        Request request = new Request.Builder().url(url).put(body).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();

                listener.onComplete(null, new Error(e.getMessage()));
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                var body = response.body().string();
                if (response.isSuccessful()) {
                    listener.onComplete(true, null);
                } else {
                    System.out.println(body);
                    var error = gson.fromJson(body, Error.class);


                    listener.onComplete(null, error);
                }
                System.out.println(body);

            }
        });


    }

    public void enterWaitingYard(String tripId, OnCompleteListener<Boolean> listener) {
        var url = baseUrl + "Reservations/Gates/Enter-Waiting-Yard";
        var requestBody = "{" +
                          "\"tripId\":\"" + tripId + "\"," +
                          "\"vehicleType\": 0" +
                          "}";
        Request request = new Request.Builder().url(url).
                put(RequestBody.create(requestBody, MediaType.get("application/json"))).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
                e.printStackTrace();
                listener.onComplete(null, new Error(e.getMessage()));
            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {
                String body = response.body().string();
                if (!response.isSuccessful()) {
                    var error = gson.fromJson(body, Error.class);
                    listener.onComplete(null, error);
                }
                listener.onComplete(true, null);
            }
        });
    }

    public void exitExchangeYard(String tripId, OnCompleteListener<Boolean> listener) {
        var url = baseUrl + "Reservations/Gates/Exit-Exchange-Yard";
        var requestBody = "{" +
                          "\"tripId\":\"" + tripId + "\"," +
                          "\"vehicleType\": 0" +
                          "}";
        Request request = new Request.Builder().url(url).
                put(RequestBody.create(requestBody, MediaType.get("application/json"))).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
                e.printStackTrace();
                listener.onComplete(null, new Error(e.getMessage()));
            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {
                String body = response.body().string();
                if (!response.isSuccessful()) {
                    var error = gson.fromJson(body, Error.class);
                    listener.onComplete(null, error);
                }
                listener.onComplete(true, null);
            }
        });
    }

}

