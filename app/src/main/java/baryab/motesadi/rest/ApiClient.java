package baryab.motesadi.rest;

import android.content.Context;

import baryab.motesadi.AppController;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppController.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
