package com.ilhamfikri.info_kopid19.api;

import com.ilhamfikri.info_kopid19.model.ModelIndonesia;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET(ApiUrl.END_POINT_INDO)
    Call<ModelIndonesia> getIndonesia();
}
