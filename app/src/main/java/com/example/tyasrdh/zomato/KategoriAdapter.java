package com.example.tyasrdh.zomato;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class KategoriAdapter extends ArrayAdapter<KategoriModel> {
    Context context;
    int resource;

    public KategoriAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.kategori_title = convertView.findViewById(R.id.kategori_title);
            holder.kategori_outlet = convertView.findViewById(R.id.kategori_outlet);
            holder.kategori_desc = convertView.findViewById(R.id.kategori_desc);
            holder.kategori_image = convertView.findViewById(R.id.kategori_image);
            holder.itemLayout = convertView.findViewById(R.id.itemLayout);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.kategori_title.setText(getItem(position).getTitle());
        holder.kategori_outlet.setText(getItem(position).getOutlet() + "Outlet");
        holder.kategori_desc.setText(getItem(position).getDesc());
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantActivity.class);
                intent.putExtra("URL", getItem(position).getImageUrl());
                context.startActivity(intent);
            }
        });


        new AmbilGambar(holder.kategori_image).execute(new String[]{getItem(position).getImageUrl()});
        return convertView;
    }

    class Holder {
        TextView kategori_title, kategori_outlet, kategori_desc;
        ImageView kategori_image;
        RelativeLayout itemLayout;
    }

}

