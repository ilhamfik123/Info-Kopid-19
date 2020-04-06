
package com.ilhamfikri.info_kopid19.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelKabupaten {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Boolean getError() {
        return mError;
    }

    public void setError(Boolean error) {
        mError = error;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
