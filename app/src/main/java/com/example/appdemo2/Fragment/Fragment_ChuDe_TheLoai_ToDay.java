package com.example.appdemo2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.appdemo2.Model.ChuDe;
import com.example.appdemo2.Model.TheLoai;
import com.example.appdemo2.Model.Theloaitrongngay;
import com.example.appdemo2.R;
import com.example.appdemo2.Service.APIService;
import com.example.appdemo2.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_ToDay extends Fragment {
    View view;
    TextView txtxemthemchudetheloai;
    HorizontalScrollView horizontalScrollView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);
        txtxemthemchudetheloai = (TextView) view.findViewById(R.id.textviewxemthemchudetheloai);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollview);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<Theloaitrongngay> callback = dataservice.GetCategoryMusic();
        callback.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay = response.body();

                final ArrayList<ChuDe> chuDeArraylist = new ArrayList<>();
                chuDeArraylist.addAll(theloaitrongngay.getChude());

                final ArrayList<TheLoai> theLoaiArraylist = new ArrayList<>();
                theLoaiArraylist.addAll(theloaitrongngay.getTheloai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);

                for (int i=0; i < chuDeArraylist.size(); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chuDeArraylist.get(i).getHinhchude() != null){
                        Picasso.with(getActivity()).load(chuDeArraylist.get(i).getHinhchude()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }

                for (int j=0; j < theLoaiArraylist.size(); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArraylist.get(j).getHinhtheloai() != null){
                        Picasso.with(getActivity()).load(theLoaiArraylist.get(j).getHinhtheloai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }

                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });
    }
}
