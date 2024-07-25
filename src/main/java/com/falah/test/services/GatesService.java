package com.falah.test.services;


import com.falah.test.core.OnCompleteListener;
import com.falah.test.models.Error;
import com.falah.test.models.Trip;
import com.falah.test.models.TripWeighted;
import com.google.gson.Gson;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class GatesService {


    public static final String BASE_URL = "https://bexy-api.digital-logic.tech/api/Reservations/";
    public static final String BASE_URL_GATES = BASE_URL + "Gates/";

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
        var url = BASE_URL + "Weighbridges/" + (fuull ? "Full" : "Empty");
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
}

