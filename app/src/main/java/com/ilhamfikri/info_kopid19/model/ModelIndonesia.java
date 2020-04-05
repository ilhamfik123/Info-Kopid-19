package com.ilhamfikri.info_kopid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelIndonesia {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("positif")
    @Expose
    private int positif;
    @SerializedName("sembuh")
    @Expose
    private int sembuh;
    @SerializedName("meninggal")
    @Expose
    private int meninggal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositif() {
        return positif;
    }

    public void setPositif(int positif) {
        this.positif = positif;
    }

    public int getSembuh() {
        return sembuh;
    }

    public void setSembuh(int sembuh) {
        this.sembuh = sembuh;
    }

    public int getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(int meninggal) {
        this.meninggal = meninggal;
    }

}