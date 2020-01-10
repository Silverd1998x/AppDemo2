package com.example.appdemo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo2.Model.Baihat;
import com.example.appdemo2.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> baihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = baihatArrayList.get(position);
        holder.txtten.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtten,txtcasi;
        ImageView imghinh, imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = (TextView) itemView.findViewById(R.id.textviewtenbaihathot);
            txtcasi = (TextView) itemView.findViewById(R.id.textviewtencasibaihathot);
            imghinh = (ImageView) itemView.findViewById(R.id.imageviewbaihathot);
            imgluotthich = (ImageView) itemView.findViewById(R.id.imageviewluotthich);
        }
    }
}
