
package com.ilhamfikri.info_kopid19.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Datum {

    @SerializedName("Last_Update")
    private String mLastUpdate;
    @SerializedName("Latitude")
    private String mLatitude;
    @SerializedName("Longitude")
    private String mLongitude;
    @SerializedName("Nama_Kabupaten")
    private String mNamaKabupaten;
    @SerializedName("ODP")
    private String mODP;
    @SerializedName("PDP")
    private String mPDP;
    @SerializedName("Positif")
    private String mPositif;
    @SerializedName("Provinsi")
    private Provinsi mProvinsi;

    public String getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getNamaKabupaten() {
        return mNamaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        mNamaKabupaten = namaKabupaten;
    }

    public String getODP() {
        return mODP;
    }

    public void setODP(String oDP) {
        mODP = oDP;
    }

    public String getPDP() {
        return mPDP;
    }

    public void setPDP(String pDP) {
        mPDP = pDP;
    }

    public String getPositif() {
        return mPositif;
    }

    public void setPositif(String positif) {
        mPositif = positif;
    }

    public Provinsi getProvinsi() {
        return mProvinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        mProvinsi = provinsi;
    }

}
