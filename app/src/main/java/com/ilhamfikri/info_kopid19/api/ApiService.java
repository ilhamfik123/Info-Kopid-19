package com.ilhamfikri.info_kopid19.api;

import com.ilhamfikri.info_kopid19.model.ModelIndonesia;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(ApiUrl.URL_ROOT_HTTP)
    Call<ModelIndonesia> getIndonesia();
}
