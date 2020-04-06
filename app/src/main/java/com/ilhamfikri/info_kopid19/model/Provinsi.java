
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
    private String mMeninggal;
    @SerializedName("Nama_Provinsi")
    private String mNamaProvinsi;
    @SerializedName("Positif")
    private String mPositif;
    @SerializedName("Sembuh")
    private String mSembuh;

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

    public String getMeninggal() {
        return mMeninggal;
    }

    public void setMeninggal(String meninggal) {
        mMeninggal = meninggal;
    }

    public String getNamaProvinsi() {
        return mNamaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        mNamaProvinsi = namaProvinsi;
    }

    public String getPositif() {
        return mPositif;
    }

    public void setPositif(String positif) {
        mPositif = positif;
    }

    public String getSembuh() {
        return mSembuh;
    }

    public void setSembuh(String sembuh) {
        mSembuh = sembuh;
    }

}
