
package com.ilhamfikri.info_kopid19.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Provinsi {

    @SerializedName("Last_Update")
    private String mLastUpdate;
    @SerializedName("Latitude")
    private String mLatitude;
    @SerializedName("Longitude")
    private String mLongitude;
    @SerializedName("Meninggal")
    private int mMeninggal;
    @SerializedName("Nama_Provinsi")
    private String mNamaProvinsi;
    @SerializedName("Positif")
    private int mPositif;
    @SerializedName("Sembuh")
    private int mSembuh;

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

    public int getMeninggal() {
        return mMeninggal;
    }

    public void setMeninggal(int meninggal) {
        mMeninggal = meninggal;
    }

    public String getNamaProvinsi() {
        return mNamaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        mNamaProvinsi = namaProvinsi;
    }

    public int getPositif() {
        return mPositif;
    }

    public void setPositif(int positif) {
        mPositif = positif;
    }

    public int getSembuh() {
        return mSembuh;
    }

    public void setSembuh(int sembuh) {
        mSembuh = sembuh;
    }

}
