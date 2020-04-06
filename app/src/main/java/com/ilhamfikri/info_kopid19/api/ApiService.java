package com.ilhamfikri.info_kopid19.api;

import com.ilhamfikri.info_kopid19.model.Datum;
import com.ilhamfikri.info_kopid19.model.ModelIndonesia;
import com.ilhamfikri.info_kopid19.model.ModelKabupaten;
import com.ilhamfikri.info_kopid19.model.Provinsi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(ApiUrl.URL_ROOT_HTTP)
    Call<List<ModelIndonesia>> getIndonesia();

    @GET(ApiUrl.URL_KAB)
    Call<List<Provinsi>> getProvinsi();
}
