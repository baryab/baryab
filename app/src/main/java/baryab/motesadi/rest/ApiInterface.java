package baryab.motesadi.rest;

import baryab.motesadi.models.ProvinceType;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("InitDraft/GetInit")
    Call<ProvinceType> getProvince();

}
