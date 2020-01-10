package com.example.appdemo2.Service;

import com.example.appdemo2.Model.Album;
import com.example.appdemo2.Model.Baihat;
import com.example.appdemo2.Model.Playlist;
import com.example.appdemo2.Model.Quangcao;
import com.example.appdemo2.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();
}
