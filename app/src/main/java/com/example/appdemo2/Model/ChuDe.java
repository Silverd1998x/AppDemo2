package com.example.appdemo2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe {

    @SerializedName("IdChuDe")
    @Expose
    private String idchude;

    @SerializedName("TenChuDe")
    @Expose
    private String tenchude;

    @SerializedName("HinhChuDe")
    @Expose
    private String hinhchude;

    public String getIdchude() {
        return idchude;
    }

    public void setIdchude(String idchude) {
        this.idchude = idchude;
    }

    public String getTenchude() {
        return tenchude;
    }

    public void setTenchude(String tenchude) {
        this.tenchude = tenchude;
    }

    public String getHinhchude() {
        return hinhchude;
    }

    public void setHinhchude(String hinhchude) {
        this.hinhchude = hinhchude;
    }
}
