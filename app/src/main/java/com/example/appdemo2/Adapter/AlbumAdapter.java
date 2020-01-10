package com.example.appdemo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo2.Model.Album;
import com.example.appdemo2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHoler> {

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Album album = mangalbum.get(position);
        holder.txttencasialbum.setText(album.getTencasiAlbum());
        holder.txttenalbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imghinhalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        ImageView imghinhalbum;
        TextView txttenalbum,txttencasialbum;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            imghinhalbum = (ImageView) itemView.findViewById(R.id.imageviewAlbum);
            txttenalbum = (TextView) itemView.findViewById(R.id.textviewtenalbum);
            txttencasialbum = (TextView) itemView.findViewById(R.id.textviewtencasialbum);
        }
    }
}
