package com.example.appdemo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdemo2.Model.Playlist;
import com.example.appdemo2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHoler{
        ImageView imgbackgroundplaylist, imgplaylist;
        TextView txttenplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoler viewHoler = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);

            viewHoler = new ViewHoler();
            viewHoler.txttenplaylist  = (TextView) convertView.findViewById(R.id.textviewtenplaylist);
            viewHoler.imgbackgroundplaylist = (ImageView) convertView.findViewById(R.id.imageviewbackgroundplaylist);
            viewHoler.imgplaylist = (ImageView) convertView.findViewById(R.id.imageviewplaylist);

            convertView.setTag(viewHoler);
        } else {
            viewHoler = (ViewHoler) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlaylist()).into(viewHoler.imgbackgroundplaylist);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewHoler.imgplaylist);
        viewHoler.txttenplaylist.setText(playlist.getTen());

        return convertView;
    }
}
