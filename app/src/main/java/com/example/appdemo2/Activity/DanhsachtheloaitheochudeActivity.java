package com.example.appdemo2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appdemo2.Adapter.DanhsachtheloaitheochudeAdapter;
import com.example.appdemo2.Model.ChuDe;
import com.example.appdemo2.Model.TheLoai;
import com.example.appdemo2.R;
import com.example.appdemo2.Service.APIService;
import com.example.appdemo2.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    Toolbar toolbartheloaitheochude;
    RecyclerView recyclerViewtheloaitheochude;
    DanhsachtheloaitheochudeAdapter danhsachtheloaitheochudeAdapter;

    ChuDe chuDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> callback = dataservice.GetTheloaitheochude(chuDe.getIdchude());
        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai = (ArrayList<TheLoai>) response.body();
                danhsachtheloaitheochudeAdapter = new DanhsachtheloaitheochudeAdapter(DanhsachtheloaitheochudeActivity.this,mangtheloai);
                recyclerViewtheloaitheochude.setLayoutManager(new GridLayoutManager(DanhsachtheloaitheochudeActivity.this,2));
                recyclerViewtheloaitheochude.setAdapter(danhsachtheloaitheochudeAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }

    private void init() {
        toolbartheloaitheochude = findViewById(R.id.toolbartheloaitheochude);
        recyclerViewtheloaitheochude = findViewById(R.id.recyclerviewtheloaitheochude);
        setSupportActionBar(toolbartheloaitheochude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenchude());
        toolbartheloaitheochude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("chude")){
            chuDe = (ChuDe) intent.getSerializableExtra("chude");
        }
    }
}
