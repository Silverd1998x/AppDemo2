package com.example.appdemo2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TheLoai implements Serializable {

    @SerializedName("IdTheLoai")
    @Expose
    private String idtheloai;

    @SerializedName("IdKeyChuDe")
    @Expose
    private String idkeychude;

    @SerializedName("TenTheLoai")
    @Expose
    private String tentheloai;

    @SerializedName("HinhTheLoai")
    @Expose
    private String hinhtheloai;

    public String getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(String idtheloai) {
        this.idtheloai = idtheloai;
    }

    public String getIdkeychude() {
        return idkeychude;
    }

    public void setIdkeychude(String idkeychude) {
        this.idkeychude = idkeychude;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getHinhtheloai() {
        return hinhtheloai;
    }

    public void setHinhtheloai(String hinhtheloai) {
        this.hinhtheloai = hinhtheloai;
    }
}
