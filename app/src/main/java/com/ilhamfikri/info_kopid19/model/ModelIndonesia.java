package com.ilhamfikri.info_kopid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelIndonesia {
    @SerializedName("name")
    private String name;
    @SerializedName("positif")
    private String positif;
    @SerializedName("sembuh")
    private String sembuh;
    @SerializedName("meninggal")

    private String meninggal;
public ModelIndonesia(String positif, String sembuh, String meninggal){
this.positif=positif;
this.sembuh=sembuh;
this.meninggal=meninggal;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

}
